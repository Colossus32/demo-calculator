package com.colossus.democalculator.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    String calculateEasyTask(int salary, int vacation);
}
