package com.careerit.jfs.cj.day2;

import java.util.Scanner;

public class AssignmentBillCalculator {

    public static void main(String[] args) {
        // Accept bill amount from user if amount is more than 1000  then discount is 10% otherwise no discount
        // Calculate the final amount after applying the discount display output in following format
        // Sample output:
        // Bill amount is 1200
        // Discount amount is 120
        // Final amount is 1080

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bill amount: ");
        double billAmount = sc.nextDouble();
        double discount = 0;
        if (billAmount >= 1000) {
            discount = billAmount * 0.10; // 10% discount
        }
        double finalAmount = billAmount - discount;

        System.out.println("Bill amount is :" + billAmount);
        System.out.println("Discount amount is :" + discount);
        System.out.println("Net amount is :" + finalAmount);
    }
}
