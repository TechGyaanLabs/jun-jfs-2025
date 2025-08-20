package com.careerit.jfs.cj.day10;

public class StringExample6 {

    public static void main(String[] args) {

        String data = "123454321";
        for (int i = data.length() - 1; i >= 0; i--) {
            System.out.println(data.charAt(i));
        }
        System.out.println(isPalindrome(data));
    }

    public static boolean isPalindrome(String data) {
        for (int i = 0, j = data.length() - 1; i <= j; i++, j--) {
            if (data.charAt(i) != data.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
