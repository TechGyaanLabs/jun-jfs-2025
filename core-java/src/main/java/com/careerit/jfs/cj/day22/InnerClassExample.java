package com.careerit.jfs.cj.day22;


import java.util.Scanner;

@FunctionalInterface
interface MathOperation {
    double perform(double num1, double num2);
}


class MathService {

    double calculate(MathOperation mathOperation, double num1, double num2) {
        return mathOperation.perform(num1, num2);
    }
}


public class InnerClassExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MathService mathService = new MathService();
        double result = mathService.calculate(
                (num1,  num2)-> num1 - num2, 5,9);
        System.out.println(result);
    }


}
