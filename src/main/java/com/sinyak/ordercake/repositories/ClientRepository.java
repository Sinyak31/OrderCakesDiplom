package com.sinyak.ordercake.repositories;

import com.sinyak.ordercake.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
