package com.careerit.jfs.cj.day5;

import java.util.Scanner;

public class FactorsOfGivenNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its factors:");
        int num = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nTotal number of factors: " + count +" for the number " + num);

        // Q. What is the prime number?
        // Ans: A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

        if(count == 2) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
