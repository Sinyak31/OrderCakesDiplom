package com.sinyak.ordercake.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Order> orderList;

    public Client(String name, String surName, String email, String phone_number) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone_number = phone_number;
    }

    public void addOrderCakesToClient(Order order){
        if(orderList == null){
            orderList = new ArrayList<>();
        }
        orderList.add(order);
       order.setClient(this);
    }
}
