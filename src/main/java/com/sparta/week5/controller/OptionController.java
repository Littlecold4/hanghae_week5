package com.sparta.week5.controller;

import com.sparta.week5.dto.OptionDto;
import com.sparta.week5.model.Options;
import com.sparta.week5.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OptionController {
    private final OptionService optionService;

    @PostMapping("/register/option")
    public Options registerOption(@RequestBody OptionDto optionDto){
        return optionService.registerOption(optionDto);
    }

}
