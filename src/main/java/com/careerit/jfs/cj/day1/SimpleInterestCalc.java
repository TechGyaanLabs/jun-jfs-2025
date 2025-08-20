package com.careerit.jfs.cj.day1;

public class SimpleInterestCalc {

    public static void main(String[] args) {
        double principal = 10000; // Principal amount
        double rate = 5; // Rate of interest per annum
        int time = 2; // Time in years

        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;

        // Print the result
        System.out.println("Simple Interest for Principal: " + principal + ", Rate: " + rate + "%, Time: " + time + " years is: " + simpleInterest);
    }
}
