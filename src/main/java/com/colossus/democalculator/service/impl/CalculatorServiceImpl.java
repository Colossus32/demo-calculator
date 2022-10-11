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
    public String calculateEasyTask(double salary, int vacation) {

        log.info("starting method calculateEasyTask");
        if (salary < 0 || vacation <= 0) {
            log.error("invalid arguments in calculateEasyTask " + this.getClass());
            throw new IllegalArgumentException();
        }
        log.info("arguments are OK");

        double result = salary / vacation;
        return String.valueOf(new DecimalFormat("#0.00").format(result));
    }

    @Override
    public String calculateAdditionalTask(String startVacation, int days, double salary) {

        log.info("starting method calculateAdditionalTask");
        if (days <= 0 || salary <= 0) {
            log.error("invalid arguments in calculateAdditionalTask " + this.getClass());
            throw new IllegalArgumentException();
        }
        LocalDate date = LocalDate.parse(startVacation);

        log.info("arguments are OK");
        int vacationDays = 0;

        while(days > 0) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int month = date.getMonthValue(); // 1-12
            int currentDay = date.getDayOfMonth(); //1-31
            if (!dayOfWeek.equals(DayOfWeek.SATURDAY) && !dayOfWeek.equals(DayOfWeek.SUNDAY) && !Utils.checkHoliday(month,currentDay)) vacationDays++;

            date = date.plusDays(1);
            days--;
        }

        if (vacationDays == 0) return "0.00";

        double result = salary / vacationDays;
        return String.valueOf(new DecimalFormat("#0.00").format(result));
    }


}
