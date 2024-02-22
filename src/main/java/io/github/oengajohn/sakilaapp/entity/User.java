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
@Table(name = "users")
public class User {
    @Id
   
    @Column(value = "id")
    private Integer id;

    @Column(value = "name")
    private String name;

    @Column(value = "username")
    private String username;

    @Column(value = "user_password")
    private String userPassword;

    @Column(value = "email")
    private String email;

    @Column(value = "picture")
    private String picture;

    @Column(value = "group_id")
    private Integer groupId;


}
