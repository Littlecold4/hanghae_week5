package com.sparta.week5.model;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.dto.OptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean open;

    @Column(nullable = false)
    private String category;

    @OneToMany
    @JoinColumn(name="foodId")
    private List<Options> Options;

//    @ManyToOne
//    @JoinColumn
//    private Restaurant restaurant;

    public Food(FoodDto foodDto, Long restaurantId){
        this.name = foodDto.getName();
        this.restaurantId=restaurantId;
        this.price = foodDto.getPrice();
        this.category = foodDto.getCategory();
        this.Options = foodDto.getOptions();
    }
    public Food(Options options){
        this.Options = (List<com.sparta.week5.model.Options>) options;
    }

    public void update(FoodDto foodDto){
        this.open = foodDto.isOpen();
    }
}
