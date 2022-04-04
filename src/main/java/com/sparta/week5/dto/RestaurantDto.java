package com.sparta.week5.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantDto {
    Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
    private int positionX;
    private int positionY;
    private boolean open = true;
    private Long ownerId;
}
