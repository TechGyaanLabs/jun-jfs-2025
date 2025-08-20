package com.careerit.jfs.cj.exception;

import java.util.Scanner;

public class ExceptionExample1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter another number: ");
        int num2 = sc.nextInt();
        int result = num1 / num2;
        System.out.println("Result: " + result);
        sc.close();
    }
}
