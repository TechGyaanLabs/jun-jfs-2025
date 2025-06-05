package com.careerit.jfs.cj.day1;

public class BiggestOfTwoNumbers {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int biggest;

        if (num1 > num2) {
            biggest = num1;
        } else {
            biggest = num2;
        }

        System.out.println("Biggest of " + num1 + " and " + num2 + " is: " + biggest);
    }
}
