package io.github.oengajohn.sakilaapp.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "user_groups")
public class Group {
    @Id
    @Column(value = "group_id")
    private Integer id;

    private String value;
}
