package com.sparta.week5.dto;

import com.sparta.week5.model.FoodOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrder> foods;
    private int deliveryFee;
    private int totalPrice;
}
