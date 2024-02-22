package io.github.oengajohn.sakilaapp.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ActorInfo {
    @Column(value = "actor_id")
    private Integer actorId;

    @Size(max = 45)
    @NotNull
    @Column(value = "first_name")
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(value = "last_name")
    private String lastName;


    @Column(value = "film_info")
    private String filmInfo;

}