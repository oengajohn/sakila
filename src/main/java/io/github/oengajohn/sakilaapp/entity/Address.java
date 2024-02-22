package io.github.oengajohn.sakilaapp.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class Address {
    @Id
    @Column(value = "address_id")
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(value = "address")
    private String address;

    @Size(max = 50)
    @Column(value = "address2")
    private String address2;

    @Size(max = 20)
    @NotNull
    @Column(value = "district")
    private String district;

    @NotNull
    @Column(value = "city_id")
    private Integer cityId;

    @Size(max = 10)
    @Column(value = "postal_code")
    private String postalCode;

    @Size(max = 20)
    @NotNull
    @Column(value = "phone")
    private String phone;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;

    @Column(value = "location")
    private Point location;


}