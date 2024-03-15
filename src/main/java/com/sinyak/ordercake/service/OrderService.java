package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Order;
import com.sinyak.ordercake.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;



    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }




}
