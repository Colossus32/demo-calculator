package com.colossus.democalculator.controller;

import com.colossus.democalculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculacte")
@RequiredArgsConstructor
@Slf4j
public class CalculatorController {

    private final CalculatorService service;

    @GetMapping
    public String getMoney(@RequestParam Double salary, @RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer vacation){
        log.info("request to /simple");
        return service.calculateEasyTask(salary,year, month, vacation);
    }

    @GetMapping
    public String getMoney(@RequestParam String vacation, @RequestParam Integer days, @RequestParam Double salary ){
        log.info("request to /additional");
        return service.calculateAdditionalTask(vacation, days, salary);
    }
}
