package com.sparta.week5.service;

import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant registerRestaurant(RestaurantDto restaurantDto){
        int minOrderPrice = restaurantDto.getMinOrderPrice();
        int deliveryFee = restaurantDto.getDeliveryFee();

        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurant = checkRestaurantLimit(minOrderPrice, deliveryFee, restaurant);
        return restaurantRepository.save(restaurant);
    }

    private Restaurant checkRestaurantLimit(int minOrderPrice, int deliveryFee, Restaurant restaurant) {
        if(minOrderPrice <1000 || minOrderPrice >100000){
             throw new IllegalArgumentException("하이");
        }
        if(minOrderPrice %100 !=0){
            throw new IllegalArgumentException("하이");
        }
        if(deliveryFee <0 || deliveryFee >10000){
            throw new IllegalArgumentException("하이");
        }
        if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("하이");
        }
        return restaurant;
    }
}
