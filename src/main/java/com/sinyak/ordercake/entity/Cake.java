package com.sinyak.ordercake.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cake")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_cake")
    private String nameCake;
    @Column(name = "description_cake")
    private String descriptionCake;
    @Column(name = "cost_one_kg")
    private int costOneKg;
    @Lob
    private String image;

}