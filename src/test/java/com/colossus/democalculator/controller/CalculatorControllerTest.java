package com.colossus.democalculator.controller;

import com.colossus.democalculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    CalculatorController controller = new CalculatorController(new CalculatorServiceImpl());

    @Test
    @DisplayName("should_be_ok_simple_task")
    void getMoneySimpleTask() {
        String response = controller.getMoneySimpleTask(10000.00, 22, 12 , 10);
        assertEquals("3225,81", response);
    }

    @Test
    void shouldFailOnWrongParameterSalarySimpleTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneySimpleTask(-20.00, 22, 12, 10));
    }
    @Test
    void shouldFailOnWrongParameterYearSimpleTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneySimpleTask(100.00, 0, 12, 10));
    }
    @Test
    void shouldFailOnWrongParameterMonthSimpleTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneySimpleTask(100.00, 22, 13, 10));
    }
    @Test
    void shouldFailOnWrongParameterVacationSimpleTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneySimpleTask(100.00, 22, 12, -2));
    }

    @Test
    @DisplayName("should_be_ok_additional_task")
    void getMoneyAdditionalTask() {
        String response = controller.getMoneyAdditionalTask("2022-02-01",30, 28650.00);
        assertEquals("21289,46", response);
    }

    @Test
    void shouldFailOnWrongParameterDateAdditionalTask(){
        assertThrows(DateTimeParseException.class,()-> controller.getMoneyAdditionalTask("20a2-02-01",30,28650.00));
    }

    @Test
    void shouldFailOnWrongParameterDateLimitsAdditionalTask(){
        assertThrows(DateTimeParseException.class,()-> controller.getMoneyAdditionalTask("2022-13-01",30,28650.00));
    }

    @Test
    void shouldFailOnWrongParameterDaysAdditionalTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneyAdditionalTask("2022-12-01",0,28650.00));
    }

    @Test
    void shouldFailOnWrongParameterSalaryAdditionalTask(){
        assertThrows(IllegalArgumentException.class,()-> controller.getMoneyAdditionalTask("2022-12-01",30,0.00));
    }
}