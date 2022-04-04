package com.sparta.week5.service;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @Transactional(rollbackOn = Exception.class)
    public void registerFood(List<FoodDto> foodDtos, Long restaurantId) {
        for (FoodDto foodDto : foodDtos) {
//            foodService.registerFood(foodDtos.get(i),restaurantId);
            int price = foodDto.getPrice();
            Optional<Food> foundResult;
            if (price < 100 || price > 1000000) {
                throw new IllegalArgumentException("오류1");
            }
            if (price % 100 != 0) {
                throw new IllegalArgumentException("오류2");
            }
            foundResult = foodRepository.findByRestaurantIdAndName(restaurantId, foodDto.getName());
            if (foundResult.isPresent()) {
                throw new IllegalArgumentException("중복!!!");
            }
            Food food = new Food(foodDto, restaurantId);
            foodRepository.save(food);
        }
    }

    public List<Food> UpdateOpenFood(Long restaurantId,Long id){
        List<Food> foods = foodRepository.findAllByRestaurantId(restaurantId);
        for(int i=0; i<foods.size(); i++){
            Food food = foods.get(i);
            if(food.getId() == id) {
                FoodDto foodDto = FoodDto.builder()
                        .name(food.getName())
                        .price(food.getPrice())
                        .open(!food.isOpen())
                        .build();
                food.update(foodDto);
            }
        }
        return foods;
    }
}
