package com.colossus.democalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {


    @GetMapping
    public String getMoney(@RequestParam Integer salary, @RequestParam Integer vacation){
        return null;
    }
}
