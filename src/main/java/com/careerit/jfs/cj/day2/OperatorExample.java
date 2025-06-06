package com.careerit.jfs.cj.day2;

public class OperatorExample {

    public static void main(String[] args) {
        // = assignment operator
        int num1 = 28; // Assigning value 10 to variable num1
        int num2 = 5; // Assigning value 20 to variable num2
        int sum = num1 + num2; // Using + operator to add num1 and num2

        // Arithmetic Operators

        int difference = num1 - num2; // Subtraction
        int product = num1 * num2; // Multiplication
        int quotient = num1 / num2; // Division
        int remainder = num1 % num2; // Modulus (remainder of division)

        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
        System.out.println("Difference of " + num1 + " and " + num2 + " is: " + difference);
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + product);
        System.out.println("Quotient of " + num1 + " and " + num2 + " is: " + quotient);
        System.out.println("Remainder of " + num1 + " and " + num2 + " is: " + remainder);
    }
}
