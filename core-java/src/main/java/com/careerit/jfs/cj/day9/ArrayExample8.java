package com.careerit.jfs.cj.day9;

import java.util.Arrays;

public class ArrayExample8 {

    public static void main(String[] args) {


        int[][] arr = new int[][]{
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5},
                {4, 5, 6}
        };
        int[] rowSum = rowSum(arr);
        System.out.println(Arrays.toString(rowSum));

        int[] columnSum = columnSum(arr);
        System.out.println(Arrays.toString(columnSum));

    }

    public static int[] rowSum(int[][] arr) {
        int[] rowSum = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            rowSum[index++] = sum;
        }
        return rowSum;
    }

    public static int[] columnSum(int[][] arr) {
        int[] columnSum = new int[arr[0].length];
        int index = 0;
        for(int i = 0; i < arr[0].length; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                sum += arr[j][i];
            }
            columnSum[index++] = sum;
        }
        return columnSum;
    }

    public static int[] maxValueInRow(int[][] arr) {
        return null;
    }

    public static int[] maxValueInColumn(int[][] arr) {
        return null;
    }

}
