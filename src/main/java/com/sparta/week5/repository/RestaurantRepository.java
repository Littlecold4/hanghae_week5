package com.sparta.week5.repository;

import com.sparta.week5.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long Id);
    List<Restaurant> findAllByOpen(boolean open);
//    List<Restaurant> findAllByCategory(String category);
}
