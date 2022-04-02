package com.sparta.week5.controller;

import com.sparta.week5.dto.OrderRequestDto;
import com.sparta.week5.model.OrderList;
import com.sparta.week5.repository.OrderRepository;
import com.sparta.week5.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderList order(@RequestBody OrderRequestDto requestDto){

        return orderService.readOrders(requestDto);
    }

    @PostMapping("/order/request/{x}/{y}")
    public OrderList orderPlus(@RequestBody OrderRequestDto requestDto,
                           @PathVariable int x,
                           @PathVariable int y){

        return orderService.readOrdersPlus(requestDto,x,y);
    }

    @GetMapping("/orders")
    public List<OrderList> readOrders(){
        return orderRepository.findAll();
    }
}
