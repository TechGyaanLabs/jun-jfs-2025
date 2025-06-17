package com.careerit.jfs.cj.day8;

import com.careerit.jfs.cj.day1.NumberQuestions;

import java.util.List;

public class CalculatorManager {

    public static void main(String[] args) {

            int a = 10;
            int b = 5;

            Calculator calculator = new Calculator();

            int add = calculator.add(a, b);
            int subtract = calculator.subtract(a, b);
            int multiply = calculator.multiply(a, b);
            int divide = calculator.divide(a, b);
            int modulus = calculator.modulus(a, b);
            int power = calculator.power(a, b);

            System.out.println("Addition: " + add);
            System.out.println("Subtraction: " + subtract);
            System.out.println("Multiplication: " + multiply);
            System.out.println("Division: " + divide);
            System.out.println("Modulus: " + modulus);
            System.out.println("Power: " + power);

            int lb = 10;
            int ub = 100;

            NumberQuestions numberQuestions = new NumberQuestions();
            List<Integer> primes = numberQuestions.getPrimeNumberInRange(lb, ub);
            System.out.println(primes);

    }
}
