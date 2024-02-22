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
public class FilmCategoryId implements Serializable {
    private static final long serialVersionUID = 4969973510656090302L;
    @Column(value = "film_id")
    private Integer filmId;

    @Column(value = "category_id")
    private Short categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryId that = (FilmCategoryId) o;
        return Objects.equals(filmId, that.filmId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

}