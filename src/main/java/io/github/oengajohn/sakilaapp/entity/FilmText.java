package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "film_text")
public class FilmText {
    @Id
    @Column(value = "film_id")
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(value = "title")
    private String title;

    @Column(value = "description")
    private String description;

}