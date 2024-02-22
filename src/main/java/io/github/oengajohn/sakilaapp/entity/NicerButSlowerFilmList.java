package io.github.oengajohn.sakilaapp.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NicerButSlowerFilmList {
    @Column(value = "FID")
    private Integer fid;

    @Size(max = 128)
    @NotNull
    @Column(value = "title")
    private String title;

    @Column(value = "description")
    private String description;

    @Size(max = 25)
    @Column(value = "category")
    private String category;

    @NotNull
    @Column(value = "price")
    private BigDecimal price;

    @Column(value = "length")
    private Integer length;

    @Column(value = "rating")
    private String rating;

    @Column(value = "actors")
    private String actors;

}