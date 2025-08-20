package com.careerit.jfs.cj.day3;

import java.util.Scanner;

public class GradeSystem {

    public static void main(String[] args) {
        /*
           Grade System
            9 - 10. A
            6 -  8. B
            4 -  5. C
            0 -  3. D
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the score: ");
        int score = sc.nextInt();
        char grade;
        if(score >= 0 && score <= 3) {
            grade = 'D';
        } else if(score >= 4 && score <= 5) {
            grade = 'C';
        } else if(score >= 6 && score <= 8) {
            grade = 'B';
        } else if(score >= 9 && score <= 10) {
            grade = 'A';
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 10.");
            sc.close();
            return;
        }
        System.out.println("Your grade is: " + grade);
        sc.close();

    }
}
