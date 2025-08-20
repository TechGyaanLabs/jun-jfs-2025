package com.careerit.jfs.cj.exception;

public class ExceptionExample5 {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            double result = getResult(a, b);

            System.out.println("Result: " + result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static double getResult(int a, int b) {
        return divide(a, b);
    }

    public static double divide(int a, int b) {
        return a / b;
    }
}
