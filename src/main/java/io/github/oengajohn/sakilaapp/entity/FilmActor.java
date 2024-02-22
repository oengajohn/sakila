package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "film_actor")
public class FilmActor {

    @Column(value = "actor_id")
    private Integer actorId;

    @Column(value = "film_id")
    private Integer filmId;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;

}