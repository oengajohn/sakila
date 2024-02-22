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
@Table(name = "rental")
public class Rental {
    @Id
    @Column(value = "rental_id")
    private Integer id;

    @NotNull
    @Column(value = "rental_date")
    private Instant rentalDate;

    @NotNull
    private Integer inventoryId;

    @NotNull
    @Column(value = "customer_id")
    private Integer customerId;

    @Column(value = "return_date")
    private Instant returnDate;

    @NotNull
    @Column(value = "staff_id")
    private Short staffId;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;

}