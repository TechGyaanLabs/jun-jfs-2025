package com.careerit.jfs.cj.day21;

import java.util.Scanner;

interface MathOperation {

    double perform(double num1, double num2);
}

class AddOperation implements MathOperation {
    @Override
    public double perform(double num1, double num2) {
        return num1 + num2;
    }
}

class SubOperation implements MathOperation {

    @Override
    public double perform(double num1, double num2) {
        return num1 > num2 ? num1 - num2 : num2 - num1;
    }

}

class MulOperation implements MathOperation {

    @Override
    public double perform(double num1, double num2) {
        return num1 * num2;
    }

}


class DivOperation implements MathOperation {

    @Override
    public double perform(double num1, double num2) {
        return num1 / num2;
    }

}


class MathService {

    double calculate(MathOperation mathOperation, double num1, double num2) {
        return mathOperation.perform(num1, num2);
    }
}

public class InnerClassExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add 2.Sub 3.Mul 4.Div Enter your choice: ");
        int choice = sc.nextInt();
        MathOperation mathOperation = getInstance(choice);
        MathService mathService = new MathService();
        double result = mathService.calculate(mathOperation, 5,9);
        System.out.println(result);
    }

    public static MathOperation getInstance(int choice){

        return switch (choice) {
            case 1 -> new AddOperation();
            case 2 -> new SubOperation();
            case 3 -> new MulOperation();
            case 4 -> new DivOperation();
            default-> throw new IllegalArgumentException("Unknown Operation");
        };
    }
}
