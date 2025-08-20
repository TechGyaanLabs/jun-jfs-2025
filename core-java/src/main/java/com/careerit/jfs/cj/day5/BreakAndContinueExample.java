package com.careerit.jfs.cj.day5;

public class BreakAndContinueExample {

    public static void main(String[] args) {
        // Q. What is the break and continue statements in Java?
        // Break statement is used to exit from the loop or switch statement.
        // Continue statement is used to skip the current iteration of the loop.

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.print(i+" ");
        }
        System.out.println("\n");
        // Continue example
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(i+" ");
        }

    }
}
