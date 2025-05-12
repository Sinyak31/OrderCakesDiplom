package com.sinyak.ordercake.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



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

