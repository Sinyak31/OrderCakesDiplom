package com.sinyak.ordercake.repositories;

import com.sinyak.ordercake.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake,Integer> {
}
