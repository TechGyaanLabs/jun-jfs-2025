package com.careerit.jfs.cj.day23;

public class TypeCastExample {

    public static void main(String... args) {


            int a = 10;
            double b = a;   // implicit type casting, it is done automatically by the compiler
            System.out.println(b);

            double price =104.90;
            int amount = (int)price; // explicit type casting, it is done manually by the developer
            System.out.println(amount);


            String str = "34500.50";
            double num = Double.parseDouble(str);
            System.out.println("The number is " + num);
            // int -> Integer
            // double -> Double
            // float -> Float
            // long -> Long
            // byte -> Byte
            // short -> Short
            // char -> Character
            // boolean -> Boolean

            int num1 = 15;
            String binaryStr = Integer.toBinaryString(num1);
            System.out.println(binaryStr);

            String numStr = Integer.toString(num1);
            System.out.println(numStr);


            int num2 = 150;
            Integer num3 = num2; // autoboxing

            Integer num4 = 150;
            int num5 = num4;  // unboxing

        // Casting, Parsing, Boxing, Unboxing

        // Var args length variable

        TypeCastExample obj = new TypeCastExample();

        obj.sum(10,20);
        obj.sum(10,20,30);
        obj.sum(10,20,30,40);
        System.out.println(obj.sum(1));
        System.out.println(obj.sum(1,2,3,4,5,6,7,8,9,10));
        System.out.println(obj.sum(1,2,3,4,5,6));
        //System.out.println(obj.sum(10,20,30,40,50));
    }

    public int sum(int a, int b){
        return a + b;
    }
    public int sum(int a, int b, int c){
        return a + b + c;
    }

    public int sum(int a, int b, int c, int d){
        return a + b + c + d;
    }

    public int sum(int init,int... arr){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res += arr[i];
        }
        return res;
    }

}
