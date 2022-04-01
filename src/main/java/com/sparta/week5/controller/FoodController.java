package com.sparta.week5.controller;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;

    @PostMapping("restaurent/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId,
                             @RequestBody List<FoodDto> foodDtos){
        for(int i=0; i<foodDtos.size(); i++){
            Food food = new Food(foodDtos.get(i),restaurantId);
            foodRepository.save(food);
        }
    }

    @GetMapping("restaurent/{restaurantId}/foods")
    public List<Food> readMenu(@PathVariable Long restaurantId){
        return  foodRepository.findAllByRestaurantId(restaurantId);
    }
}
