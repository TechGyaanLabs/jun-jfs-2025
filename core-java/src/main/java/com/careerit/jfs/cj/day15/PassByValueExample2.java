package com.careerit.jfs.cj.day15;

public class PassByValueExample2 {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;
        System.out.println("Before increment num1 = " + num1 + " num2 = " + num2);
        increment(num1, num2);
        System.out.println("After increment num1 = " + num1 + " num2 = " + num2);
    }

    private static void increment(int num1, int num2) {
        num1++;
        num2++;
    }
}
