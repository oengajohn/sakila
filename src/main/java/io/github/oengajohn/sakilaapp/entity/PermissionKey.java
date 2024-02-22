package io.github.oengajohn.sakilaapp.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class PermissionKey {

    @Column(value = "menu_id")
    private Integer menuId;

    @Column(value = "group_id")
    private Integer groupId;
}
