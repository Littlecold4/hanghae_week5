package com.sparta.week5.dto;

import com.sparta.week5.model.Options;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private boolean open;
    private Long ownerId;
    private List<Options> Options;
}
