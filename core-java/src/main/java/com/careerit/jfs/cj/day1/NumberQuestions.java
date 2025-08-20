package com.careerit.jfs.cj.day1;

import java.util.ArrayList;
import java.util.List;

public class NumberQuestions {


        public List<Integer> getPrimeNumberInRange(int start, int end) {
            List<Integer> primes = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            return primes;
        }

        public boolean isPrime(int num) {
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
}
