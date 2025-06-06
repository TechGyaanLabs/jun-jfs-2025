package com.careerit.jfs.cj.day2;

import java.util.Scanner;

public class EmiCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Annual Interest Rate (in %): ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter Loan Tenure (in months): ");
        int tenureMonths = sc.nextInt();


        // Convert annual rate to monthly and percentage to decimal
        double monthlyRate = (annualRate / 100) / 12;

        double emi = principal * monthlyRate * (
                Math.pow(1 + monthlyRate, tenureMonths) /
                        (Math.pow(1 + monthlyRate, tenureMonths) - 1)
        );

        double totalPayment = emi * tenureMonths;
        double totalInterest = totalPayment - principal;

        System.out.println("EMI: " + Math.round(emi));
        System.out.println("Total Payment: " + Math.round(totalPayment));
        System.out.println("Total Interest: " + Math.round(totalInterest));
    }
}
