package com.sinyak.ordercake.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private int house;
    @Column(name = "flat")
    private int flat;
    @Column(name = "delivery_date")
    private String delivery_date;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "delivery")
    private List<Order> orderList;

    public Delivery(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public void addOrderCakesToClient(Order order){
        if(orderList == null){
            orderList = new ArrayList<>();
        }
        orderList.add(order);
        order.setDelivery(this);
    }
}
