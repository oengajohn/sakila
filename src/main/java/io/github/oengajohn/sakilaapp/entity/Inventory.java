package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
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
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(value = "inventory_id")
    private Integer id;

    @NotNull
  @Column(value = "film_id")
    private Integer filmId;

    @NotNull

    @Column(value = "store_id")
    private Short storeId;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;

}