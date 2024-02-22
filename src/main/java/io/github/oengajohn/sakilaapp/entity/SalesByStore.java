package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesByStore {
    @Size(max = 101)
    @Column(value = "store")
    private String store;

    @Size(max = 91)
    @Column(value = "manager")
    private String manager;

    @Column(value = "total_sales")
    private BigDecimal totalSales;

}