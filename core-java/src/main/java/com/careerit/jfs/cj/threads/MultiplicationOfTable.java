package com.careerit.jfs.cj.threads;

public class MultiplicationOfTable extends Thread {

    @Override
    public void run() {
        int num = 2;
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Start of main method "+Thread.currentThread().getName());
        MultiplicationOfTable mt = new MultiplicationOfTable();
        mt.setName("MultiplicationOfTable");
        mt.start();
        System.out.println("End of main method "+Thread.currentThread().getName());

    }
}
