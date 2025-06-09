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

        double emi = calculateEmi(principal, annualRate, tenureMonths);
        displayResult(emi, tenureMonths, principal);
    }

    private static void displayResult(double emi, int tenureMonths, double principal) {
        double totalPayment = emi * tenureMonths;
        double totalInterest = totalPayment - principal;
        System.out.println("EMI: " + Math.round(emi));
        System.out.println("Total Payment: " + Math.round(totalPayment));
        System.out.println("Total Interest: " + Math.round(totalInterest));
    }

    private static double calculateEmi(double principal, double interestRate, int tenureMonths) {
        double monthlyInterest = interestRate / 12 / 100;
        return principal * monthlyInterest *
                Math.pow(1 + monthlyInterest, tenureMonths) / 
                (Math.pow(1 + monthlyInterest, tenureMonths) - 1);

    }
}
