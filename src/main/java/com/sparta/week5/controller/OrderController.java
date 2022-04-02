package com.sparta.week5.controller;

import com.sparta.week5.dto.OrderRequestDto;
import com.sparta.week5.model.OrderList;
import com.sparta.week5.repository.OrderRepository;
import com.sparta.week5.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/orders")
    public List<OrderList> readOrders(){
        return orderRepository.findAll();
    }
}
