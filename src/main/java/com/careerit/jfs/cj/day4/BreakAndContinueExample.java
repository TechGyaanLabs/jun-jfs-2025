package com.careerit.jfs.cj.day4;

public class BreakAndContinueExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if(i % 3 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
