package com.sparta.week5.controller;

import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    @PostMapping(" /restaurant/register")
    public void registerRestaurant(){

    }

    @GetMapping("/restaurants")
    public List<Restaurant> readRestaurant(){
        return restaurantRepository.findAll();
    }
}
