package com.colossus.democalculator.controller;

import com.colossus.democalculator.service.CalculatorService;
import com.colossus.democalculator.service.impl.CalculatorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculator")
@RequiredArgsConstructor
@Slf4j
public class CalculatorController {

    private final CalculatorServiceImpl service;

    @GetMapping("/simple")
    public String getMoney(@RequestParam Double salary, @RequestParam Integer vacation){
        log.info("request to /simple");
        return service.calculateEasyTask(salary,vacation);
    }

    @GetMapping("/additional")
    public String getMoneyAdditional(@RequestParam String startVacation,@RequestParam Integer days, @RequestParam Double salary ){
        log.info("request to /additional");
        return service.calculateAdditionalTask(startVacation, days, salary);
    }
}
