package io.github.oengajohn.sakilaapp.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permissions")
public class Permission {

    @Column(value = "menu_id")

    private Integer menuId;

    @Column(value = "group_id")
    private Integer groupId;
}
