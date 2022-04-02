package com.sparta.week5.service;

import com.sparta.week5.dto.FoodOrderDto;
import com.sparta.week5.dto.FoodOrderRequestDto;
import com.sparta.week5.dto.OrderRequestDto;
import com.sparta.week5.model.FoodOrder;
import com.sparta.week5.model.OrderList;
import com.sparta.week5.repository.FoodOrderRepository;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.repository.OrderRepository;
import com.sparta.week5.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodOrderRepository foodOrderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository,FoodRepository foodRepository,RestaurantRepository restaurantRepository,FoodOrderRepository foodOrderRepository){
        this.orderRepository = orderRepository ;
        this.foodRepository = foodRepository ;
        this.restaurantRepository = restaurantRepository ;
        this.foodOrderRepository = foodOrderRepository ;
    }

    public OrderList readOrders(OrderRequestDto requestDto){
        int howManyOrder = requestDto.getFoods().size();
        int quantity =0;
        int totalprice = 0;
        int price = 0;
        List<FoodOrder> foodOrders = new ArrayList<>();
        Long restaurantId = requestDto.getRestaurantId();
        String restaurantName = restaurantRepository.findRestaurantById(restaurantId).getName();
        int deliveryFee = restaurantRepository.findRestaurantById(restaurantId).getDeliveryFee();

        for(int i=0; i<howManyOrder; i++){
            FoodOrderRequestDto foodOrderRequestDto =requestDto.getFoods().get(i);
            quantity = foodOrderRequestDto.getQuantity();
            price = foodRepository.findByRestaurantIdAndId(restaurantId,foodOrderRequestDto.getId()).getPrice();
            String foodName =  foodRepository.findByRestaurantIdAndId(restaurantId,foodOrderRequestDto.getId()).getName();
            FoodOrderDto orderDto= new FoodOrderDto();
            orderDto.setName(foodName);
            orderDto.setPrice(price*quantity);
            orderDto.setQuantity(quantity);
            totalprice += foodOrderRequestDto.getQuantity() * price;
            FoodOrder foodOrder = new FoodOrder(orderDto);
            foodOrderRepository.save(foodOrder);
            foodOrders.add(foodOrder);
        }
        OrderLimit(quantity, totalprice, restaurantId);
        totalprice += deliveryFee;
        OrderList orderList = new OrderList(restaurantName,foodOrders,deliveryFee,totalprice);


        orderRepository.save(orderList);
        return orderList;
    }

    public OrderList readOrdersPlus(OrderRequestDto requestDto,int myX,int myY){
        int howManyOrder = requestDto.getFoods().size();
        int quantity =0;
        int totalprice = 0;
        int price = 0;
        Long restaurantId = requestDto.getRestaurantId();
        int restaurantX =  restaurantRepository.findRestaurantById(restaurantId).getPositionX();
        int restaurantY =  restaurantRepository.findRestaurantById(restaurantId).getPositionY();
        int distance = Math.abs(myX - restaurantX) + Math.abs(myY - restaurantY);
        if (distance > 3) {
            throw new IllegalArgumentException("배달 불가 지역입니다람쥐");
        }
        List<FoodOrder> foodOrders = new ArrayList<>();
        String restaurantName = restaurantRepository.findRestaurantById(restaurantId).getName();
        int deliveryFee = restaurantRepository.findRestaurantById(restaurantId).getDeliveryFee() +distance*500;

        for(int i=0; i<howManyOrder; i++){
            FoodOrderRequestDto foodOrderRequestDto =requestDto.getFoods().get(i);
            quantity = foodOrderRequestDto.getQuantity();
            price = foodRepository.findByRestaurantIdAndId(restaurantId,foodOrderRequestDto.getId()).getPrice();
            String foodName =  foodRepository.findByRestaurantIdAndId(restaurantId,foodOrderRequestDto.getId()).getName();
            FoodOrderDto orderDto= new FoodOrderDto();
            orderDto.setName(foodName);
            orderDto.setPrice(price*quantity);
            orderDto.setQuantity(quantity);
            totalprice += foodOrderRequestDto.getQuantity() * price;
            FoodOrder foodOrder = new FoodOrder(orderDto);
            foodOrderRepository.save(foodOrder);
            foodOrders.add(foodOrder);
        }
        OrderLimit(quantity, totalprice, restaurantId);
        totalprice += deliveryFee;
        OrderList orderList = new OrderList(restaurantName,foodOrders,deliveryFee,totalprice);


        orderRepository.save(orderList);
        return orderList;
    }

    private void OrderLimit(int quantity, int totalprice, Long restaurantId) {
        if(quantity <1|| quantity >100){
            throw new IllegalArgumentException("수량 1미만");
        }
        if(totalprice <restaurantRepository.findRestaurantById(restaurantId).getMinOrderPrice()){
            throw new IllegalArgumentException("최소금액 미달");
        }
    }
}
