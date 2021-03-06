package com.pizza.crm.repository;

import com.pizza.crm.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Override
    List<Dish> findAll();

    Dish getDishByName(String name);

}
