package com.sinyak.ordercake.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Entity
@Table(name = "cake")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameCake;

    private String descriptionCake;

    private int costOneKg;

    @Lob
    private String image;

    private OffsetDateTime crateAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Categories categories;
}