package com.careerit.jfs.cj.day9;

public class ArrayExample3 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 8, 4, 2, 9, 6};
        int big = biggest(arr);
        int small = smallest(arr);
        int sum = sum(arr);
        System.out.println("Biggest number: " + big);
        System.out.println("Smallest number: " + small);
        System.out.println("Sum of numbers : " + sum);

    }

    public static int biggest(int[] arr) {
        int big = arr[0]; // Assume first element is biggest
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > big) {
                big = arr[i];
            }
        }
        return big;
    }

    public static int smallest(int[] arr) {
        int small = arr[0]; // Assume first element is smallest
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        return small;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        return sum;
    }
}
