package com.sinyak.ordercake.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @NotEmpty(message = "В пароле должны быть символы")
    @Size(min = 3, message = "Пароль должен состоять минимум из 3-х символов")
    private String password;
    private String roles;
    private String email;

    public User(){
        roles="ROLE_USER";
    }

}

