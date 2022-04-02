package com.sparta.week5.controller;

import com.sparta.week5.dto.MyHomeDto;
import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.login.UserRoleEnum;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantRepository;
import com.sparta.week5.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

//    @Secured(value = UserRoleEnum.Authority.CEO)
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registerRestaurant(restaurantDto);
    }

//    @Secured(value = UserRoleEnum.Authority.USER)
    @GetMapping("/restaurants")
    public List<Restaurant> readRestaurant(){
        return restaurantRepository.findAll();
    }

//       @Secured(value = UserRoleEnum.Authority.USER)
    @GetMapping("/restaurants/available/{x}/{y}")
    public List<Restaurant> availableRestaurants(@PathVariable int x,
                                                 @PathVariable int y){
        return restaurantService.availableRestaurants(x,y);
    }
}
