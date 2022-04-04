package com.sparta.week5.model;

import com.sparta.week5.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(nullable = false)
    private boolean open;

    @Column(nullable = false)
    private Long ownerId;

    public Restaurant(RestaurantDto restaurantDto){
        this.name = restaurantDto.getName();
        this.minOrderPrice=restaurantDto.getMinOrderPrice();
        this.deliveryFee=restaurantDto.getDeliveryFee();
        this.positionX = restaurantDto.getPositionX();
        this.positionY = restaurantDto.getPositionY();
        this.open = restaurantDto.isOpen();
        this.ownerId = restaurantDto.getOwnerId();
    }
    public long update(RestaurantDto restaurantDto){
        this.open = restaurantDto.isOpen();
        return id;
    }
}
