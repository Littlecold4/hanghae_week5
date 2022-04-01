package com.sparta.week5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;
}