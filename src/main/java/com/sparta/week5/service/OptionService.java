package com.sparta.week5.service;

import com.sparta.week5.dto.OptionDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.model.Options;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.repository.OptionRepository;
import com.sparta.week5.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor@Service
public class OptionService {
    private final OptionRepository optionRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public Options registerOption(OptionDto optionDto){

        Options options = new Options(optionDto);
        optionRepository.save(options);
        Restaurant restaurant = new Restaurant(options);
        Food food = new Food(options);
        restaurantRepository.save(restaurant);
        foodRepository.save(food);
        return options;
    }
}
