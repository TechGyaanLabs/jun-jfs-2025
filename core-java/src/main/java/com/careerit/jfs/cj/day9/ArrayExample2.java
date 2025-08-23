package com.careerit.jfs.cj.day9;

import java.util.Scanner;

public class ArrayExample2 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 3, 4, 5, 6, 17, 8, 91, 10, 11, 12, 13, 34, 15, 16, 17, 18, 19, 20};
        // Print only divisible 5 values

        for (int ele : arr) {
            if (ele % 5 != 0) {
                continue;
            }
            System.out.println(ele);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to search: ");
        int key = sc.nextInt();
        int index = search(arr, key);
        if(index != -1){
            System.out.println("Element "+key+" found at index "+index);
        }else{
            System.out.println("Element "+key+" is not found");
        }
    }

    // If element is present it will return index otherwise return -1
    private static int search(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int valueAtIndex(int[] arr, int index){
        if(index < 0 || index > arr.length -1){
            throw new IllegalArgumentException("Invalid index number");
        }
        return arr[index];
    }
}
