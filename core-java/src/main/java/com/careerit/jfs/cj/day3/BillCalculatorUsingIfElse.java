package com.careerit.jfs.cj.day3;

import java.util.Scanner;

public class BillCalculatorUsingIfElse {

    public static void main(String[] args) {
        // Accept bill amount from user, if amount is greater than 1000 then discount is 10% otherwise discount is 5%
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bill amount: ");
        double billAmount = sc.nextDouble();
        double discount = 0;
        if (billAmount >= 1000) {
            discount = billAmount * 0.10; // 10% discount
        } else {
            discount = billAmount * 0.05; // 5% discount
        }
        double finalAmount = billAmount - discount;
        System.out.println("Bill amount is: " + billAmount);
        System.out.println("Discount amount is: " + discount);
        System.out.println("Net amount is: " + finalAmount);
        sc.close();

    }
}
