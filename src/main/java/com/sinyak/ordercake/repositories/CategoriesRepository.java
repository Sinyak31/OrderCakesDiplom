package com.sinyak.ordercake.repositories;

import com.sinyak.ordercake.entity.Categories;
import com.sinyak.ordercake.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
