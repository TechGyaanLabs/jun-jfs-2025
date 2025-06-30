package com.careerit.jfs.cj.day14;

class Demo {

    static int count = 10;
    {
        System.out.println("IIB");
    }

    static {
        System.out.println("SIB");
    }

    public Demo() {
        System.out.println("Demo constructor called");

    }
}

public class StaticBlockExample {

    static {
        System.out.println("SIB from Main -1");
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
    static{
        System.out.println("SIB from Main-2");
    }
}
