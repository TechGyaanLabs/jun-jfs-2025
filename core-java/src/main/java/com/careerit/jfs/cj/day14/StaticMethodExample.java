package com.careerit.jfs.cj.day14;

public class StaticMethodExample {

    static int res = 9999;
    public static void main(String[] args) {
        System.out.println(MyMathUtil.add(10, 20));
        System.out.println(MyMathUtil.gcd(27, 36, 45));
        System.out.println(res);
        showGreetings();
    }

    private static void showGreetings(){
        System.out.println("Welcome to Java world!");
    }
}
