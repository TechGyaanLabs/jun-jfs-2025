package com.careerit.jfs.cj.day13;

import org.apache.commons.lang3.ArrayUtils;

public class Manager {

    public static void main(String[] args) {

        NumberQuestions obj = new NumberQuestions();
        int[] primes = obj.getPrimeNumberInRange(10,100);
        System.out.println(ArrayUtils.toString(primes));

        Careerit.out.println("Hello");
    }
}
