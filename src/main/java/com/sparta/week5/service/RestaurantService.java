package com.sparta.week5.service;

import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,FoodRepository foodRepository){
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
    }

    public Restaurant registerRestaurant(RestaurantDto restaurantDto){
        int minOrderPrice = restaurantDto.getMinOrderPrice();
        int deliveryFee = restaurantDto.getDeliveryFee();

        Restaurant restaurant = new Restaurant(restaurantDto);
        checkRestaurantLimit(minOrderPrice, deliveryFee, restaurant);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> availableRestaurants(int myX, int myY){
        List<Restaurant> Restaurants = restaurantRepository.findAll();
        List<Restaurant> availRestaurants = new ArrayList<>();
        for (Restaurant restaurant : Restaurants) {
            int restaurantX = restaurant.getPositionX();
            int restaurantY = restaurant.getPositionY();
            if (Math.abs(myX - restaurantX) + Math.abs(myY - restaurantY) <= 3) {
                availRestaurants.add(restaurant);
            }
        }
        return availRestaurants;
    }

    public List<Restaurant> readCategory(String query){
        List<Food> foods = foodRepository.findAllByCategory(query);
        List<Restaurant> restaurants =new ArrayList<>();
        restaurants.add(restaurantRepository.findRestaurantById(foods.get(0).getRestaurantId()));
        for(int i=1; i<foods.size(); i++){
            if(!Objects.equals(foods.get(i).getRestaurantId(), foods.get(i - 1).getRestaurantId())){
                restaurants.add(restaurantRepository.findRestaurantById(foods.get(i).getRestaurantId()));
            }
        }
        return restaurants;
    }

    @Transactional
    public Restaurant openUpdate(Long id){
        Restaurant restaurant = restaurantRepository.findRestaurantById(id);
        RestaurantDto restaurantDto = RestaurantDto.builder()
                        .id(restaurant.getId())
                        .name(restaurant.getName())
                        .minOrderPrice(restaurant.getMinOrderPrice())
                        .deliveryFee(restaurant.getDeliveryFee())
                        .positionX(restaurant.getPositionX())
                        .positionY(restaurant.getPositionY())
                        .open(!restaurant.isOpen())
                        .build();
        restaurant.update(restaurantDto);
        return  restaurant;
    }




    private void checkRestaurantLimit(int minOrderPrice, int deliveryFee, Restaurant restaurant) {
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
    }
}
