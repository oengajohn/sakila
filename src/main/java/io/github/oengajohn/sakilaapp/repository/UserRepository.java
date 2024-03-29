package io.github.oengajohn.sakilaapp.repository;

import io.github.oengajohn.sakilaapp.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
    Mono<User> findByUsername(String username);
}
