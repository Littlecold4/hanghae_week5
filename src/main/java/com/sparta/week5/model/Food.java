package com.sparta.week5.model;

import com.sparta.week5.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(String name, Long restaurantId,int price){
        this.name = name;
        this.restaurantId=restaurantId;
        this.price = price;
    }
    public Food(FoodDto foodDto, Long restaurantId){
        this.name = foodDto.getName();
        this.restaurantId=restaurantId;
        this.price = foodDto.getPrice();
    }
    public Food(FoodDto foodDto){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }

}
