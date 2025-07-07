package com.careerit.jfs.cj.day18;

import java.util.Scanner;
import java.util.UUID;

abstract class Payment {
    public abstract void makePayment(String sssn, double amount);

    public void printReceipt(String txnId, String ssn, double amount, String status) {
        System.out.println("Transaction Id: " + txnId);
        System.out.println("SSN: " + ssn);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
    }
}

class CreditCard extends Payment {
    @Override
    public void makePayment(String sssn, double amount) {
        System.out.println("Payment made using Credit card");
        printReceipt(UUID.randomUUID().toString(), sssn, amount, "SUCCESS");
    }
}

class DebitCard extends Payment {
    @Override
    public void makePayment(String sssn, double amount) {
        System.out.println("Payment made using Debit card");
        printReceipt(UUID.randomUUID().toString(), sssn, amount, "SUCCESS");
    }
}

class UPI extends Payment {
    @Override
    public void makePayment(String sssn, double amount) {
        System.out.println("Payment made using UPI");
        printReceipt(UUID.randomUUID().toString(), sssn, amount, "SUCCESS");
    }
}

public class PaymentExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter SSN    :");
        String ssn = sc.next();
        System.out.println("Enter amount :");
        double amount = sc.nextDouble();
        System.out.println("1.Credit Card\n2.Debit Card\n3.UPI");
        int choice = sc.nextInt();
        Payment payment = getPayment(choice);
        payment.makePayment(ssn, amount);
    }

    private static Payment getPayment(int choice) {
        return switch (choice) {
            case 1 -> new CreditCard();
            case 2 -> new DebitCard();
            case 3 -> new UPI();
            default -> throw new IllegalArgumentException("Unexpected value: " + choice);
        };
    }
}
