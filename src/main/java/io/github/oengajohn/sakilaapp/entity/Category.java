package io.github.oengajohn.sakilaapp.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
public class Category {
    @Id
    @Column(value = "category_id")
    private Short id;

    @Size(max = 25)
    @NotNull
    @Column(value = "value")
    private String value;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;




}