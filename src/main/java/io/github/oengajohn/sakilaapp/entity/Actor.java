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
@Table(name = "actor")
public class Actor {
    @Id
    @Column(value = "actor_id")
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(value = "first_name")
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(value = "last_name")
    private String lastName;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;



}