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
@Table(name = "staff")
public class Staff {
    @Id
    @Column(value = "staff_id")
    private Short id;

    @Size(max = 45)
    @NotNull
    @Column(value = "first_value")
    private String firstvalue;

    @Size(max = 45)
    @NotNull
    @Column(value = "last_value")
    private String lastvalue;

    @NotNull
    @Column(value = "address_id")
    private Integer addressId;

    @Column(value = "picture")
    private byte[] picture;

    @Size(max = 50)
    @Column(value = "email")
    private String email;

    @NotNull
    @Column(value = "store_id")
    private Short store_id;

    @NotNull
    @Column(value = "active")
    private Boolean active = false;

    @Size(max = 16)
    @NotNull
    @Column(value = "uservalue")
    private String uservalue;

    @Size(max = 40)
    @Column(value = "password")
    private String password;

    @NotNull
    @Column(value = "last_update")
    private Instant lastUpdate;


}