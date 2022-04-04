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

    @Column(nullable = false)
    private boolean open;

    @Column(nullable = false)
    private String category;

    public Food(String name, Long restaurantId,int price, String category){
        this.name = name;
        this.restaurantId=restaurantId;
        this.price = price;
        this.category= category;
    }
    public Food(FoodDto foodDto, Long restaurantId){
        this.name = foodDto.getName();
        this.restaurantId=restaurantId;
        this.price = foodDto.getPrice();
        this.category = foodDto.getCategory();
    }

    public void update(FoodDto foodDto){
        this.open = foodDto.isOpen();
    }
}
