package io.github.oengajohn.sakilaapp.controller;

import io.github.oengajohn.sakilaapp.controller.dto.ActorRequest;
import io.github.oengajohn.sakilaapp.controller.dto.ActorResponse;
import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaapp.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("list")
    public Mono<GenericResponse<List<ActorResponse>>> listActors() {
        return actorService.listActors();
    }

    @PostMapping("create")
    public Mono<GenericResponse<ActorResponse>> createActor(@RequestBody @Valid ActorRequest actorRequest) {
        return actorService.createActor(actorRequest);
    }

    @PutMapping("{actorId}/update")
    public Mono<GenericResponse<ActorResponse>> updateActor(@PathVariable("actorId") Integer actorId, @RequestBody @Valid ActorRequest actorRequest) {
        return actorService.updateActor(actorId, actorRequest);
    }
    @DeleteMapping("{actorId}/delete")
    public Mono<GenericResponse<?>> deleteActor(@PathVariable("actorId") Integer actorId) {
        return actorService.deleteActor(actorId);
    }
}
