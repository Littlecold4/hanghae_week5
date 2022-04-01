//package com.sparta.week5.model;
//
//import com.sparta.week5.dto.FoodOrderDto;
//import com.sparta.week5.dto.OrderDto;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@NoArgsConstructor
//@Getter
//@Entity
//public class Order {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
//
//    @Column(nullable = false)
//    private String restaurantName;
//
//    @Column(nullable = false)
//    private List<FoodOrderDto> foods;
//
//    @Column(nullable = false)
//    private int deliveryFee;
//
//    @Column(nullable = false)
//    private int totalPrice;
//
//    public Order(String restaurantName, List<FoodOrderDto> foods, int deliveryFee, int totalPrice){
//        this.restaurantName = restaurantName;
//        this.foods = foods;
//        this.deliveryFee = deliveryFee;
//        this.totalPrice= totalPrice;
//    }
//    public Order(OrderDto orderDto){
//        this.restaurantName=orderDto.getRestaurantName();
//        this.foods = orderDto.getFoods();
//        this.deliveryFee = orderDto.getDeliveryFee();
//        this.totalPrice = orderDto.getTotalPrice();
//    }
//}
