package com.sparta.week5.controller;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.login.UserRoleEnum;
import com.sparta.week5.model.Food;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;
    private final FoodService foodService;

//    @Secured(value = UserRoleEnum.Authority.CEO)
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId,
                             @RequestBody List<FoodDto> foodDtos){
        foodService.registerFood(foodDtos,restaurantId);
    }
//    @Secured(value = UserRoleEnum.Authority.USER)
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> readMenu(@PathVariable Long restaurantId){
        return  foodRepository.findAllByRestaurantId(restaurantId);
    }

    @PutMapping("/restaurant/{restaurantId}/{id}/food/open")
    public Food readOpenFood(@PathVariable Long restaurantId,
                                   @PathVariable Long id){
        return foodService.UpdateOpenFood(restaurantId,id);
    }

//    @PutMapping("/restaurant/food/open")
//    public Food openornot
}
