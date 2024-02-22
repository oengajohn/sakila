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
@ToString
@Builder
@Table(name = "store")

public class Store {
    @Id
    @Column(value = "store_id")
    private Short id;

    @NotNull
    @Column(value = "staff_id")
    private Short staffId;

    @NotNull
    @Column(value = "address_id")
    private Integer addressId;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;

}