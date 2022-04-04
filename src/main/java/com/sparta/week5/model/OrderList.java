package com.sparta.week5.model;

import com.sparta.week5.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class OrderList {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany
    @JoinColumn(name ="FoodOrderId")
    private List<FoodOrder> foods;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String status;

    public OrderList(String restaurantName, List<FoodOrder> foods, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice= totalPrice;
    }
    public OrderList(OrderDto orderDto){
        this.restaurantName=orderDto.getRestaurantName();
        this.foods = orderDto.getFoods();
        this.deliveryFee = orderDto.getDeliveryFee();
        this.totalPrice = orderDto.getTotalPrice();
        this.status = orderDto.getStatus();
    }
    public void update(OrderDto orderDto){
        this.status = orderDto.getStatus();
    }
}
