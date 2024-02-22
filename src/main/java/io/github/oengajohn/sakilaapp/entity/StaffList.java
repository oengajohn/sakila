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
public class StaffList {
    @Column(value = "ID")
    private Short id;

    @Size(max = 91)
    @Column(value = "value")
    private String value;

    @Size(max = 50)
    @NotNull
    @Column(value = "address")
    private String address;

    @Size(max = 10)
    @Column(value = "`zip code`")
    private String zipCode;

    @Size(max = 20)
    @NotNull
    @Column(value = "phone")
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(value = "city")
    private String city;

    @Size(max = 50)
    @NotNull
    @Column(value = "country")
    private String country;

    @Column(value = "SID")
    private Short sid;

}