package com.careerit.jfs.cj.day5;

import java.util.Scanner;

public class MultiplicationOfTableInRange {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lb value: ");
        int lb = sc.nextInt();
        System.out.println("Enter ub value: ");
        int ub = sc.nextInt();

        for (int num = lb; num <= ub; num++) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " * " + i + " = " + (num * i));
            }
            System.out.println("-------------------------");
        }

    }
}
