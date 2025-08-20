package com.careerit.jfs.cj.day6;

import java.util.Scanner;

public class DayNumberToDayName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day number: ");
        int dayNumber = scanner.nextInt();
        String dayName = "";
        switch (dayNumber) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                System.out.println("Invalid day number. Please enter a number between 1 and 7.");
                return; // Exit the program if the input is invalid
        }

        System.out.println("The day name for day number " + dayNumber + " is: " + dayName);
    }
}
