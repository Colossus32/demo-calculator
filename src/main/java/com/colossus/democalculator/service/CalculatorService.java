package com.colossus.democalculator.service;

public interface CalculatorService {
    String calculateEasyTask(double salary, int vacation);
    String calculateAdditionalTask(String startVacation, int days, double salary);
}
