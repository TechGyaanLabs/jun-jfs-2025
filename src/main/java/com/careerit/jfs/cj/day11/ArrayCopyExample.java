package com.careerit.jfs.cj.day11;

public class ArrayCopyExample {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3, 4, 5,};
        int[] arr2 = new int[]{4, 5, 6, 7, 8};

        int[] arr3 = new int[arr1.length + arr2.length];

        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }

    }
}
