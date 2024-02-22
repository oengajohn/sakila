package io.github.oengajohn.sakilaapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")

public class Menu {

    @Id
    @Column(value = "id")
    private Integer id;

    @NotNull
    @Column(value = "text")
    @JsonProperty("text")
    private String text;

    @Column("iconCls")
    @JsonProperty("iconCls")
    private String iconCls;

    @Column("className")
    @JsonProperty("className")
    private String className;

    @Column("menu_id")
    @JsonProperty("menuId")
    private Integer menuId;

    @JsonInclude(NON_NULL)
    private List<Menu> items;
}
