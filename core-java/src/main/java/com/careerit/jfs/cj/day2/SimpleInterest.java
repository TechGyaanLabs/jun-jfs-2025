package com.careerit.jfs.cj.day2;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter rate of interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter time in years: ");
        int time = sc.nextInt();

        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;

        // Print the result
        System.out.println("Simple Interest for Principal: " + principal + ", Rate: " + rate + "%, Time: " + time + " years is: " + simpleInterest);
        sc.close();
    }
}
