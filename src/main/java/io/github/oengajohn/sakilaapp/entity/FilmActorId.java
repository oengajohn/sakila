package io.github.oengajohn.sakilaapp.entity;


import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmActorId implements Serializable {
    private static final long serialVersionUID = -1468250781515841642L;
    @Column(value = "actor_id")
    private Integer actorId;

    @Column(value = "film_id")
    private Integer filmId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(actorId, that.actorId) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

}