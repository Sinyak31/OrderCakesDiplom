package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.*;
import com.sinyak.ordercake.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final CakeService cakeService;


    @Autowired
    public OrderService(OrderRepository orderRepository, CakeService cakeService) {
        this.orderRepository = orderRepository;
        this.cakeService = cakeService;
    }

    @Transactional
    public void save(OrderForm orderForm, int id) {
        Order order = orderForm.getOrder();
        Client client = orderForm.getClient();
        Delivery delivery = orderForm.getDelivery();
        CakeClient cakeClient = orderForm.getCakeClient();
        order.setDelivery(delivery);
        order.setClient(client);
        Optional<Cake> cake = cakeService.findCakeByID(id);
        cakeClient.setDescriptionCake(cake.get().getDescriptionCake());
        cakeClient.setNameCake(cake.get().getNameCake());
        cakeClient.setImage(cake.get().getImage());
        order.setCake(cakeClient);
        order.setDateOfCakeOrder(LocalDate.now());

        orderRepository.save(order);
    }


}
