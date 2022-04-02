package com.sparta.week5.model;

import com.sparta.week5.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int positionX;

    @Column(nullable = false)
    private int positionY;

    public Restaurant(RestaurantDto restaurantDto){
        this.name = restaurantDto.getName();
        this.minOrderPrice=restaurantDto.getMinOrderPrice();
        this.deliveryFee=restaurantDto.getDeliveryFee();
        this.positionX = restaurantDto.getPositionX();
        this.positionY = restaurantDto.getPositionY();
    }
}
