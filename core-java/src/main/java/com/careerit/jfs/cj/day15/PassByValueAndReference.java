package com.careerit.jfs.cj.day15;

public class PassByValueAndReference {

    public static void main(String[] args) {

        PassByValueAndReference ref = new PassByValueAndReference();
        int num1 = 10;
        int num2 = 20;
        System.out.println("Before swap num1 = " + num1 + " num2 = " + num2);
        ref.swap(num1, num2);

    }
    // Pass by value (int num1, int num2)
    public void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("After swap num1  = " + num1 + " num2 = " + num2);
    }

}
