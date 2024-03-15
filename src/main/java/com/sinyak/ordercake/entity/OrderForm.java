package com.sinyak.ordercake.entity;

import jakarta.persistence.Entity;
import lombok.*;

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
