//package com.sinyak.ordercake.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name = "ordercake")
//@Setter
//@Getter
//@NoArgsConstructor
//@ToString
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//    @Column(name = "cake_name")
//    private String cake_name;
//    @Column(name = "cost")
//    private int cost;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id")
//    private Client client;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "delivery_id")
//    private Delivery delivery;
//
//    public Order(String cake_name, int cost,Client client,Delivery delivery) {
//        this.cake_name = cake_name;
//        this.cost = cost;
//        this.client = client;
//        this.delivery = delivery;
//
//    }
//}


package com.sinyak.ordercake.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "ordercake")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//    @Column(name = "cake_name")
//    private String cake_name;
    @Column(name = "comment")
    private String comment;
    @Column(name = "cost")
    private int cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cake_client_id")
    private CakeClient cake;
    @Column(name = "date_of_order")
    LocalDate dateOfCakeOrder;

    public Order(String comment, int cost,Client client,Delivery delivery,CakeClient cake) {
        this.comment = comment;
        this.cost = cost;
        this.client = client;
        this.delivery = delivery;
        this.cake=cake;
        dateOfCakeOrder = LocalDate.now();

    }
}



