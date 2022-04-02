package com.sparta.week5.model;

import com.sparta.week5.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class FoodOrder {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn
    private OrderList orderList;

    public FoodOrder(FoodOrderDto orderDto){
        this.name = orderDto.getName();
        this.quantity = orderDto.getQuantity();
        this.price = orderDto.getPrice();
    }
}
