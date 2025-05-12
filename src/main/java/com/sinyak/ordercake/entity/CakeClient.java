package com.sinyak.ordercake.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cake_client")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CakeClient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_cake")
    private String nameCake;
    @Column(name = "description_cake")
    private String descriptionCake;
    @Column(name = "weight")
    private double weight;
    @Column(name = "decoration")
    private String decoration;
    @Lob
    private String image;

}

