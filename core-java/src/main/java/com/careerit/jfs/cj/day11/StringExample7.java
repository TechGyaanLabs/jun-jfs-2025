package com.careerit.jfs.cj.day11;

public class StringExample7 {


    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
       return str.contentEquals(new StringBuilder(str).reverse());
    }
}
