package com.careerit.jfs.cj.day8;

import java.util.Arrays;

public class KeyboardShortCuts {

    public static void main(String[] args) {
        int start = 10;
        int end = 100;
        int[] primes = printPrimeInRange(start, end);
        System.out.println(Arrays.toString(primes));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int primeCountInRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static int[] printPrimeInRange(int start, int end) {
        int count = primeCountInRange(start, end);
        int[] primes = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes[index++] = i;
            }
        }
        return primes;
    }
}
