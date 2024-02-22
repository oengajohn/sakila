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
@Table(name = "city")
public class City {
    @Id
    @Column(value = "city_id")
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(value = "city")
    private String city;

    @NotNull
    @Column(value = "country_id")
    private Integer country;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;


}