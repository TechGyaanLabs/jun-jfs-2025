package com.careerit.jfs.cj.threads;

public class NumberManager {
    public static void main(String[] args) {

            NumberGenerator obj1 = new NumberGenerator(10);
            NumberGenerator obj2 = new NumberGenerator(20);
            NumberGenerator obj3 = new NumberGenerator(30);

            Thread t1 = new Thread(obj1);
            Thread t2 = new Thread(obj2);
            Thread t3 = new Thread(obj3);

            t1.setName("T1");
            t2.setName("T2");
            t3.setName("T3");

            t1.start();
            t2.start();
            t3.start();


            Runnable runnable = ()-> {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                }
            };

            Thread t4 = new Thread(runnable);
            t4.setName("T4");
            t4.start();
    }
}
