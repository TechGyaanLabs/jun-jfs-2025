package com.careerit.jfs.cj.day9;

import java.util.Arrays;

public class ArrayExample6 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };

        for (int i = 0; i < arr.length; i++) {
           for(int j = 0; j < arr[i].length; j++) {
               System.out.print(arr[i][j] + " ");
           }
           System.out.println();
        }

    }
}
