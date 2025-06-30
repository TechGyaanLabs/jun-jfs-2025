package com.careerit.jfs.cj.day14;

public class MyMathUtil {


    public static int add(int a, int b) {
        return a + b;
    }

    public static int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        while(b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public static int gcd(int a, int b,int c) {
        return gcd(c,gcd(a,b));
    }
}
