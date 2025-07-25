package com.careerit.jfs.cj.day8;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }
        return a / b;
    }

    public int modulus(int a, int b) {
        return a % b;
    }

    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
