package io.github.oengajohn.sakilaapp.entity;


import jakarta.validation.constraints.NotNull;
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
public class SalesByFilmCategory {
    @Size(max = 25)
    @NotNull
    @Column(value = "category")
    private String category;

    @Column(value = "total_sales")
    private BigDecimal totalSales;

}