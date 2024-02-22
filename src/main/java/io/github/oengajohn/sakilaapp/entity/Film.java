package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "film")
public class Film {
    @Id
    @Column(value = "film_id")
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(value = "title")
    private String title;

    @Column(value = "description")
    private String description;

    @Column(value = "release_year")
    private Integer releaseYear;

    @NotNull
    @Column(value = "language_id")
    private Short languageId;


    @Column(value = "original_language_id")
    private Short originalLanguageId;

    @Column(value = "rental_duration")
    private Short rentalDuration;

    @NotNull
    @Column(value = "rental_rate")
    private BigDecimal rentalRate;

    @Column(value = "length")
    private Integer length;

    @NotNull
    @Column(value = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(value = "rating")
    private String rating;

    @Column(value = "special_features")
    private String specialFeatures;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;




}