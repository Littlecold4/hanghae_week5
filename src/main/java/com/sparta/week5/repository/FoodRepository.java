package com.sparta.week5.repository;

import com.sparta.week5.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long RestaurantId);
    Optional<Food>  findByRestaurantIdAndName(Long RestaurantId, String name);
}
