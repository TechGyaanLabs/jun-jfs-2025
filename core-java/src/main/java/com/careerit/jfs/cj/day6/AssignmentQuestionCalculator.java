package com.careerit.jfs.cj.day6;

import java.util.Scanner;

public class AssignmentQuestionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        boolean flag = true;
        do {
            System.out.print("Enter the operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            // Perform the operation based on user input and display the result


            // Ask the user to continue or exit
            System.out.print("Do you want to continue? (yes/no): ");


        }while(flag);
    }
}
