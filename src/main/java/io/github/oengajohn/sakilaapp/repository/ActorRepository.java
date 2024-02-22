package io.github.oengajohn.sakilaapp.repository;

import io.github.oengajohn.sakilaapp.entity.Actor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ActorRepository  extends ReactiveCrudRepository<Actor,Integer> {
}
