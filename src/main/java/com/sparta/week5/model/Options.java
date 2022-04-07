package com.sparta.week5.model;

import com.sparta.week5.dto.OptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Options {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String plus;

    @Column(nullable = false)
    private int addPrice;

    @Column(nullable = false)
    private boolean open;



    public Options(OptionDto optionDto){
        this.plus = optionDto.getPlus();
        this.addPrice=optionDto.getAddPrice();
        this.open = optionDto.isOpen();
    }
}
