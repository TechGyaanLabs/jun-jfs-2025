package com.careerit.jfs.cj.day2;

import java.util.Scanner;

public class ConvertAgeToProperAge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age in years: ");
        int ageInYears = sc.nextInt();

        if(ageInYears < 0) {
            ageInYears = Math.abs(ageInYears);
        }

        int months = ageInYears * 12;
        int days = months * 30;
        int hours = days * 24;
        int minutes = hours * 60;
        int seconds = minutes * 60;

        System.out.println("You have lived for:");
        System.out.println(ageInYears + " years");
        System.out.println(months + " months");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        sc.close();
    }
}
