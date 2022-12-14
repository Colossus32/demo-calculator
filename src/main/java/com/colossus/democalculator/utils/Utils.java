package com.colossus.democalculator.utils;

import java.util.*;

public class Utils {
    public static boolean checkHoliday (int month, int day) {
        Map<Integer, List<Integer>> holidays = new HashMap<>();

        holidays.put(1, new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8)));
        holidays.put(2, new ArrayList<>(Collections.singletonList(23)));
        holidays.put(3, new ArrayList<>(Collections.singletonList(8)));
        holidays.put(5, new ArrayList<>(Arrays.asList(1,9)));
        holidays.put(6, new ArrayList<>(Collections.singletonList(12)));
        holidays.put(11, new ArrayList<>(Collections.singletonList(4)));
        holidays.put(12, new ArrayList<>(Collections.singletonList(31)));

        if (!holidays.containsKey(month)) return false;
        else return new HashSet<>(holidays.get(month)).contains(day);
    }

    public static double calculateCurrentMonthDaySalary(int year, int month, double salary){

        int[] normalYear = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] leapYear = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};

        return year % 4 == 0 ? salary / leapYear[month - 1] : salary / normalYear[month - 1];
    }
}
