package com.careerit.jfs.cj.day10;

public class StringExample3 {
    public static void main(String[] args) {

        String name1 = "Krish";
        String name2 = "Krish";
        String name3 = "Krish";

        System.out.println(name1 == name2);
        System.out.println(name2 == name3);


        name1 = name1.toUpperCase();
        System.out.println(name1.toUpperCase());
        System.out.println(name2.toUpperCase());
        System.out.println(name3.toUpperCase());

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);


        String name4 = new String("Krish");
        String name5 = new String("Krish");

        String name6 = "Krish";
        String name7 = "Krish";

        System.out.println(name4 == name5);
        System.out.println(name6 == name7);

        System.out.println(name4.equals(name5));
        System.out.println(name5.equals(name6));
    }
}
