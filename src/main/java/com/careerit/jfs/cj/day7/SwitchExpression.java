package com.careerit.jfs.cj.day7;

import java.util.Scanner;

public class SwitchExpression {

    public static void main(String[] args) {

        String dayName = getDayName(1);
        System.out.println("Day name is: " + dayName);
        int monthNumber= 13;
        int yearNumber = 2023;
        int daysInMonth = numberOfDaysInMonth(monthNumber, yearNumber);
        if(daysInMonth == -1) {
            System.out.println("Invalid month number");
            return;
        }else{
            System.out.println("Number of days in month " + monthNumber + " is: " + daysInMonth);
        }
    }

    private static String getDayName(int num){
        return switch (num) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day number";
        };
    }
    private static int numberOfDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                System.out.println("Checking for leap year: " + year);
                yield isLeapYear(year) ? 29 : 28;
            }
            default -> -1;
        };

    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


}
