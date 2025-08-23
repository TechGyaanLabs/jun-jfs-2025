package com.careerit.jfs.cj.day9;

public class ArrayExample1 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Reverse of array element");

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

        // Print first 3 elements

        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }

        // Last 3 elements
        System.out.println("....................");
        for (int i = arr.length - 3; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // for-each loop
        System.out.println("using for-each");
        for (int ele : arr) {
            System.out.println(ele);
        }
    }
}
