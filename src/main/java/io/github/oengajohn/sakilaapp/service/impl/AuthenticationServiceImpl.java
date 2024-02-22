package io.github.oengajohn.sakilaapp.service.impl;

import io.github.oengajohn.sakilaapp.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaapp.entity.User;
import io.github.oengajohn.sakilaapp.repository.UserRepository;
import io.github.oengajohn.sakilaapp.service.AuthenticationService;
import io.github.oengajohn.sakilaapp.controller.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<GenericResponse<?>> authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .flatMap(user -> {
                    if (checkPassword(password, user.getUserPassword())) {
                        return Mono.just(GenericResponse.success(mapToUserDto(user), "Authentication successful."));
                    } else {
                        return Mono.just(GenericResponse.error("Incorrect credentials."));
                    }
                }).switchIfEmpty(Mono.just(GenericResponse.error("User not found.")));
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    private boolean checkPassword(String inputPassword, String dbPassword) {
        return inputPassword.equals(dbPassword);
    }
}
