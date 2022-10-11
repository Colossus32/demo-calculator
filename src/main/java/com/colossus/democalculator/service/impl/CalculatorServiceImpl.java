package com.colossus.democalculator.service.impl;

import com.colossus.democalculator.service.CalculatorService;

import java.text.DecimalFormat;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calculateEasyTask(int salary, int vacation) {
        if (salary < 0 || vacation <= 0) throw new IllegalArgumentException();
        double result = (double) salary / vacation;
        return String.valueOf(new DecimalFormat("#0.00").format(result));
    }
}
