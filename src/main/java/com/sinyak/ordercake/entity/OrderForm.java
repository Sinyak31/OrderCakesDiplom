package com.sinyak.ordercake.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class OrderForm {
    private Order order;
    private Client client;
    private Delivery delivery;
    private CakeClient cakeClient;
    private LocalDate dateOfOrder;

}
