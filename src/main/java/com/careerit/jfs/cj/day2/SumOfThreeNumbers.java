package com.careerit.jfs.cj.day2;

import java.util.Scanner;

public class SumOfThreeNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        int sum = num1 + num2 + num3;
        // Print the result
        System.out.println("Sum of " + num1 + ", " + num2 + " and " + num3 + " is: " + sum);
        sc.close();

    }
}
