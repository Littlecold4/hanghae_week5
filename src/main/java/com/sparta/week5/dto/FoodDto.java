package com.sparta.week5.dto;

import com.sparta.week5.model.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.sparta.week5.model.Options;

import java.util.List;

@Getter
@Setter
@Builder
public class FoodDto {
    private Long id;
    private String name;
    private int price;
    private  boolean open;
    private String category;
    private Restaurant restaurant;
    private List<Options> Options;
}
