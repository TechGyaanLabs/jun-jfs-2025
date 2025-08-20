package com.careerit.jfs.cj.day6;

public class WhileLoopExamples {

    public static void main(String[] args) {
        int num = 19;
        printMultiplicationTable(num);
        int n = 5;
        int fact = factorial(n);
        System.out.println("Factorial of " + n + " is: " + fact);
        int fibNum = 11;
        int fib = fibonacci(fibNum);
        System.out.println("Fibonacci of " + fibNum + " is: " + fib);
    }

    // Check given number is armstrong or not if it is armstrong return true otherwise false
    public static boolean isArmstrong(int num) {
        return false;
    }
    // 153 => 3
    // 3456 => 4
    public static int getDigitsCount(int num) {
       return 0;
    }

    public static boolean isPalindrome(int num) {
        return num == reverseOfNumber(num);
    }

    public static int reverseOfNumber(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10; // Get the last digit
            rev = rev * 10 + rem; // Shift previous digits and add the new digit
            num = num / 10; // Remove the last digit from num
        }
        return rev; // Return the reversed number
    }

    public static int sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        return sum;
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, c = 0;
        int i = 2; // Starting from the third term
        while (i <= n) {
            c = a + b; // c is the next term in the series
            a = b; // Move to the next term
            b = c; // Update b to the new term
            i++;
        }
        return c; // Return the nth Fibonacci number
    }

    public static int factorial(int n) {
        int fact = 1;
        int i = 2;
        while (i <= n) {
            fact *= i; // fact = fact * i
            i++;
        }
        return fact;
    }

    public static void printMultiplicationTable(int num) {
        int i = 1;
        while (i <= 10) {
            System.out.println(num + " * " + i + " = " + (num * i));
            i++;
        }
    }

}
