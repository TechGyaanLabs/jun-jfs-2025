package com.careerit.jfs.cj.day9;

public class ArrayExample7 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };
        int sum = 0;

        // find the diagonal sum
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Sum is :"+sum);
    }
}
