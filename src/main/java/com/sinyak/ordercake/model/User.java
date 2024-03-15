package com.sinyak.ordercake.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String roles;

    public User(){
        roles="ROLE_USER";
    }

}

