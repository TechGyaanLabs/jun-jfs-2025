package com.careerit.jfs.cj.day10;

public class StringExample1 {

    public static void main(String[] args) {

        String name1 = "John";
        String name2 = new String(new char[]{'J', 'o', 'h', 'n'});
        String name3 = new String("John");

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }
}
