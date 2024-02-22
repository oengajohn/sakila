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

@Table(name = "customer")
public class Customer {
    @Id
    @Column(value = "customer_id")
    private Integer id;

    @NotNull
    @Column(value = "store_id")
    private Short storeId;

    @Size(max = 45)
    @NotNull
    @Column(value = "first_value")
    private String firstvalue;

    @Size(max = 45)
    @NotNull
    @Column(value = "last_value")
    private String lastvalue;

    @Size(max = 50)
    @Column(value = "email")
    private String email;

    @NotNull
    @Column(value = "address_id")
    private Integer addressId;

    @NotNull
    @Column(value = "active")
    private Boolean active = false;

    @NotNull
    @Column(value = "create_date")
    private Instant createDate;

    @Column(value = "last_update")
    private Instant lastUpdate;

}