package com.sparta.week5.controller;

import com.sparta.week5.dto.MyHomeDto;
import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantRepository;
import com.sparta.week5.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registerRestaurant(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> readRestaurant(){
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/available/{x}/{y}")
    public List<Restaurant> availableRestaurants(@PathVariable int x,
                                                 @PathVariable int y){
        return restaurantService.availableRestaurants(x,y);
    }
}
