package com.careerit.jfs.cj.day17;

public class TypeCastingExamples {

    public static void main(String[] args) {

            int a = 10;
            float b = a; // implicit type casting
            System.out.println("a = " + a + " b = " + b);

            float c = 10.5f;
            int d = (int)c; // explicit type casting
            System.out.println("c = " + c + " d = " + d);

            // Parsing of values from String to numeric types

            // int - Integer, float - Float, double - Double, char - Character, boolean - Boolean, byte - Byte, short - Short

            String numStr = "100.50f";

            float num  = Float.parseFloat(numStr);
            System.out.println("num = " + num);

            String emp = "EMP1001,Krish,Developer,3000000";

            String[] arr = emp.split(",");

            double salary = Double.parseDouble(arr[3]);
            System.out.println(salary + salary * 0.1);

    }
}
