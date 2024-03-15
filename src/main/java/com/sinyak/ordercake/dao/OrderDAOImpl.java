package com.sinyak.ordercake.dao;

import com.sinyak.ordercake.entity.Client;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDAOImpl implements OrderDAO{
    private final EntityManager entityManager;

    public OrderDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrder(Client client) {
        Session session = entityManager.unwrap(Session.class);
        session.save(client);
    }
}
