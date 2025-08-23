package com.careerit.jfs.cj.day10;

public class StringExample5 {

    public static void main(String[] args) {

        String data = "  Hello World  ";
        System.out.println(data.length());
        data = data.trim();
        System.out.println(data.length());
        boolean isValidUser = login(" admin ", "admin@123");
        System.out.println(isValidUser);

        String userData = "Learning Java is Fun";
        System.out.println(userData.substring(17));
        System.out.println(userData.substring(0, 17));
        System.out.println(userData.substring(8,14).toUpperCase().length());
        System.out.println(userData.substring(8,14).trim().length());

    }

    public static boolean login(String userName, String password) {
        userName = userName.trim();
        password = password.trim();
        return userName.equals("admin") && password.equals("admin@123");
    }
}
