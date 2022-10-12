package com.colossus.democalculator.service;

public interface CalculatorService {
    String calculateEasyTask(double salary, int year, int month, int vacation);
    String calculateAdditionalTask(String vacation, int days, double salary);
}
