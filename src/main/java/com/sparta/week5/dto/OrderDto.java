package com.sparta.week5.dto;

import com.sparta.week5.model.FoodOrder;
import com.sparta.week5.model.OrderList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrder> foods;
    private int deliveryFee;
    private int totalPrice;
    private String status;

    public OrderDto(String restaurantName, List<FoodOrder> foodOrders, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foods = foodOrders;
        this.deliveryFee =deliveryFee;
        this.totalPrice = totalPrice;
        this.status = "주문 접수 중";
    }
    public OrderDto(OrderList orderList,String status){
        this.restaurantName = orderList.getRestaurantName();
        this.foods =orderList.getFoods();
        this.deliveryFee = orderList.getDeliveryFee();
        this.totalPrice = orderList.getTotalPrice();
        this.status = status;
    }
}
