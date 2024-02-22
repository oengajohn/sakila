package io.github.oengajohn.sakilaapp.service.impl;

import io.github.oengajohn.sakilaapp.controller.dto.ActorRequest;
import io.github.oengajohn.sakilaapp.controller.dto.ActorResponse;
import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaapp.entity.Actor;
import io.github.oengajohn.sakilaapp.repository.ActorRepository;
import io.github.oengajohn.sakilaapp.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Mono<GenericResponse<List<ActorResponse>>> listActors() {
        Flux<Actor> actorFlux = actorRepository.findAll();
        return actorFlux.collectList().map(this::mapToActorDtoList)
                .map(actors -> GenericResponse.success(actors, "List of actors retrieved successfully", actors.size()));
    }

    private List<ActorResponse> mapToActorDtoList(List<Actor> actors) {
        return actors.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Mono<GenericResponse<ActorResponse>> createActor(ActorRequest actorRequest) {
        Actor actorToCreate = this.toEntity(actorRequest);

        return actorRepository.save(actorToCreate)
                .map(savedActor -> GenericResponse.success(this.toDto(savedActor), "Actor created successfully"))
                .onErrorResume(error -> Mono.just(GenericResponse.error("Error creating actor: " + error.getMessage())));
    }

    @Override
    public Mono<GenericResponse<ActorResponse>> updateActor(Integer actorId, @Valid ActorRequest actorRequest) {
        return actorRepository.findById(actorId)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found with id: " + actorId)))
                .flatMap(existingActor -> {
                    existingActor.setFirstName(actorRequest.getFirstName());
                    existingActor.setLastName(actorRequest.getLastName());
                    existingActor.setLastUpdate(Instant.now());
                    // Optionally, update other fields as needed
                    return actorRepository.save(existingActor)
                            .map(updatedActor -> GenericResponse.success(this.toDto(updatedActor), "Actor updated successfully"));
                });
    }

    @Override
    public Mono<GenericResponse<?>> deleteActor(Integer actorId) {
        return actorRepository.findById(actorId)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found with id: " + actorId)))
                .flatMap(existingActor -> actorRepository.deleteById(actorId)
                        .then(Mono.just(GenericResponse.success(null, "Actor deleted successfully"))));
    }

    private Actor toEntity(ActorRequest actorRequest) {
        if (actorRequest == null) {
            return null;
        }
        Actor actor = new Actor();
        actor.setFirstName(actorRequest.getFirstName());
        actor.setLastName(actorRequest.getLastName());
        actor.setLastUpdate(Instant.now());
        return actor;
    }

    public ActorResponse toDto(Actor actor) {
        if (actor == null) {
            return null;
        }
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setFirstName(actor.getFirstName());
        actorResponse.setLastName(actor.getLastName());
        actorResponse.setLastUpdate(actor.getLastUpdate());
        return actorResponse;
    }
}
