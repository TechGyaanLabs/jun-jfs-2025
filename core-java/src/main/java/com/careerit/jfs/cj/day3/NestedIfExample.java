package com.careerit.jfs.cj.day3;

import java.util.Scanner;

public class NestedIfExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bill bill amount: ");
        double billAmount = scanner.nextDouble();
        System.out.println("Membership type (Gold/Silver/Bronze): ");
        String membershipType = scanner.next().toLowerCase();

        System.out.println("Enter the payment method (Cash/Card): ");
        String paymentMethod = scanner.next().toLowerCase();

        // If membership is gold and payment type card then 20% discount else payment type cash then 15% discount
        // if membership is silver or bronze then 10% discount regardless of any payment type
        double discount = 0;
        if(membershipType.equals("gold")) {
            if (paymentMethod.equals("card")) {
                discount = billAmount * 0.20;
            }else{
                discount = billAmount * 0.15;
            }
        }else if(membershipType.equals("silver") || membershipType.equals("bronze")) {
            discount = billAmount * 0.10;
        } else {
            System.out.println("You are not eligible for any discount.");
        }

        double finalAmount = billAmount - discount;

        System.out.println("Bill amount is: " + billAmount);
        System.out.println("Discount amount is: " + discount);
        System.out.println("Net amount is: " + finalAmount);
        scanner.close();


    }
}
