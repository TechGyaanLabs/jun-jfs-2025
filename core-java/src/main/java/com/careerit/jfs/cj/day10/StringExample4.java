package com.careerit.jfs.cj.day10;

public class StringExample4 {

    public static void main(String[] args) {

        // Split method
        String data = "apple,banana,mango,orange,jackfruit,grapes";

        String[] fruits = data.split(",");

        for (String fruit : fruits) {
            System.out.println(fruit.toUpperCase());
        }

        String empData="1001-Krish-45000,1002-Manoj-50000,1003-Praveen-55000";

        // ["1001-Krish-45000","1002-Manoj-50000","1003-Praveen-55000"]

        String[] empDetails=empData.split(",");

        for (String empDetail : empDetails) {
            String[] arr = empDetail.split("-");
            System.out.println(arr[1].substring(0,3).toUpperCase());
        }

    }
}
