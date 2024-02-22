package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
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
@Table(name = "payment")
public class Payment {
    @Id
    @Column(value = "payment_id")
    private Integer id;

    @NotNull
    @Column(value = "customer_id")
    private Integer customerId;

    @NotNull
    @Column(value = "staff_id")
    private Short staffId;

    @Column(value = "rental_id")
    private Integer rentalId;

    @NotNull
    @Column(value = "amount")
    private BigDecimal amount;

    @NotNull
    @Column(value = "payment_date")
    private Instant paymentDate;

    @Column(value = "last_update")
    private Instant lastUpdate;

}