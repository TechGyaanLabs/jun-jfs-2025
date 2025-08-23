package com.careerit.jfs.cj.day4;

import java.util.Scanner;

public class PrintEvenNumberInGivenRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start of the range: ");
        int lb = scanner.nextInt();
        System.out.print("Enter the end of the range: ");
        int ub = scanner.nextInt();
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (i % 2 == 0) {
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println("\nTotal even numbers in the range [" + lb + ", " + ub + "] is: " + count);
        scanner.close();
    }
}
