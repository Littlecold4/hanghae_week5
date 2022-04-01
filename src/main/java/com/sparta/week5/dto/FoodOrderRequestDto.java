package com.sparta.week5.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodOrderRequestDto {
    private Long id;
    private int quantity;
}
