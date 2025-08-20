package com.careerit.jfs.cj.day3;

import java.util.Scanner;

public class MultiplicationOfTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to generate its multiplication table: ");
        int num = scanner.nextInt();
        for(int i = 20; i >= 1; i--) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        scanner.close();
    }
}
