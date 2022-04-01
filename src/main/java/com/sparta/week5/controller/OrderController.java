//package com.sparta.week5.controller;
//
//import com.sparta.week5.dto.OrderDto;
//import com.sparta.week5.repository.OrderRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class OrderController {
//    private final OrderRepository orderRepository;
//
//    @PostMapping("/order/request")
//    public void order(@RequestBody OrderDto orderDto){
//        orderRepository.save(orderDto);
//    }
//
//    @GetMapping("/orders")
//    public List<Order> readOrders(){
//
//    }
//}
