package com.careerit.jfs.cj.day15;

public class FinalKeywordExample {
    final static int MAX_VALUE = 10;
    final int MIN_VALUE = 5;
    public static void main(String[] args) {

            final int DAYS_IN_WEEK = 7;
            System.out.println("Days in week : " + DAYS_IN_WEEK);

    }

    public static void increment(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }
}
