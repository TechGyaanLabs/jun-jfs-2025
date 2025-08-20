package com.careerit.jfs.cj.day15;

import java.util.Arrays;

public class PassByObjectExample {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        increment(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void increment(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }
}
