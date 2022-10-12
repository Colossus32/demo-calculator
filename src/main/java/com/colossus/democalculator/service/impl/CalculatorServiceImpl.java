package com.colossus.democalculator.service.impl;

import com.colossus.democalculator.service.CalculatorService;
import com.colossus.democalculator.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calculateEasyTask(double salary, int year, int month, int vacation) {

        log.info("starting method calculateAdditionalTask");
        if (salary < 0 || year < 1 || month < 1 || month > 12 || vacation < 0) throw new IllegalArgumentException();

        log.info("arguments are OK");
        double result = Utils.calculateCurrentMonthDaySalary(year, month, salary) * vacation;

        return String.valueOf(new DecimalFormat("#0.00").format(result));
    }

    @Override
    public String calculateAdditionalTask(String vacation, int days, double salary) {

        log.info("starting method calculateAdditionalTask");
        if (days <= 0 || salary <= 0) throw new IllegalArgumentException();

        LocalDate date = LocalDate.parse(vacation);
        log.info("arguments are OK");

        double result = 0;

        while(days-- > 0) {

            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int month = date.getMonthValue(); // 1-12
            int currentDay = date.getDayOfMonth(); //1-31
            int currentYear = date.getYear();

            if (!dayOfWeek.equals(DayOfWeek.SATURDAY) && !dayOfWeek.equals(DayOfWeek.SUNDAY) && !Utils.checkHoliday(month,currentDay)){
                double currentMonthDaySalary = Utils.calculateCurrentMonthDaySalary(currentYear, month, salary);
                result += currentMonthDaySalary;
            }

            date = date.plusDays(1);
        }

        return String.valueOf(new DecimalFormat("#0.00").format(result));
    }


}
