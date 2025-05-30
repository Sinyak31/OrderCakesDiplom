package com.sinyak.ordercake.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reviews")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "reviews_text")
    private String reviewsText;

    public Reviews(String nameClient, String reviewsText) {
        this.nameClient = nameClient;
        this.reviewsText = reviewsText;
    }
}
