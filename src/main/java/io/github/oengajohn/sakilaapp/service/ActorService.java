package io.github.oengajohn.sakilaapp.service;

import io.github.oengajohn.sakilaapp.controller.dto.ActorRequest;
import io.github.oengajohn.sakilaapp.controller.dto.ActorResponse;
import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ActorService {
    Mono<GenericResponse<List<ActorResponse>>> listActors();

    Mono<GenericResponse<ActorResponse>> createActor(ActorRequest actorRequest);

    Mono<GenericResponse<ActorResponse>> updateActor(Integer actorId, @Valid ActorRequest actorRequest);

    Mono<GenericResponse<?>> deleteActor(Integer actorId);
}
