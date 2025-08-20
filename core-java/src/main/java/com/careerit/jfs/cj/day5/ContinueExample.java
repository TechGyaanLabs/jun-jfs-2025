package com.careerit.jfs.cj.day5;

public class ContinueExample {

    public static void main(String[] args) {

        int[] empIds = new int[]{1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};

        // Print all employee ids which are not divisible by 3

        for (int i = 0; i < empIds.length; i++) {
            if (empIds[i] % 3 == 0) {
                continue; // Skip the current iteration if empIds[i] is divisible by 3
            }
            System.out.println(empIds[i]);
        }
    }
}
