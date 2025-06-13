package com.careerit.jfs.cj.day6;

import java.util.Scanner;

public class NumberDaysInGivenMonthAndYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        System.out.println("Month : " + monthName+", Year : " + year+" has " + daysInMonth + " days.");
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Invalid month number";
        }
        return monthName;
    }

    public static int getDaysInMonth(int month, int year) {
        int days = 0;
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                days = 31;
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                days = 30;
                break;
            case 2: // February
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                System.out.println("Invalid month number");
        }
        return days;
    }

    private static boolean isLeapYear(int year) {
        // A year is a leap year if it is divisible by 4,
        // but not divisible by 100, unless it is also divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
