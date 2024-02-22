package io.github.oengajohn.sakilaapp.controller;

import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaapp.controller.dto.LoginRequest;
import io.github.oengajohn.sakilaapp.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    Mono<GenericResponse<?>> authenticate(@RequestBody LoginRequest loginRequest){
        return authenticationService.authenticate(loginRequest.usename(), loginRequest.password());
    }
}
