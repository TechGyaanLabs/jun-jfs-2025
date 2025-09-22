package com.careerit.jfs.cj.threads;

public class NumberGenerator implements Runnable {

    int number;
    public NumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 1; i <= number; i++) {
            System.out.println("Thread "+Thread.currentThread()+" "+number + " ");
        }
    }

}
