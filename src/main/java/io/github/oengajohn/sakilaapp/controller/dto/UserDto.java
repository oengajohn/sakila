package io.github.oengajohn.sakilaapp.controller.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    private Integer id;

    private String name;

    private String username;

    private String email;

    private String picture;

    private Integer groupId;

}
