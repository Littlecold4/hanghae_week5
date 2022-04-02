package com.sparta.week5.repository;

import com.sparta.week5.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
}
