package io.github.oengajohn.sakilaapp.service;


import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import reactor.core.publisher.Mono;

public interface AuthenticationService {

    Mono<GenericResponse<?>> authenticate(String username, String password);
}
