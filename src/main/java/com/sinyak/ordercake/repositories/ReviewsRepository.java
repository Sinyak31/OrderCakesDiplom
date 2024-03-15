package com.sinyak.ordercake.repositories;

import com.sinyak.ordercake.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {
}
