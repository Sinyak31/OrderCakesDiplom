package com.sinyak.ordercake.repositories;

import com.sinyak.ordercake.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
