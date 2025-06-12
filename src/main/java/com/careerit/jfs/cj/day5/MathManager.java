package com.careerit.jfs.cj.day5;

public class MathManager {
    public static void main(String[] args) {

            MathCommonInterviewQuestions mciq = new MathCommonInterviewQuestions();
            int num = 13;

            boolean isEven = mciq.isEven(num);
            if(isEven) {
                System.out.println(num + " is an even number.");
            } else {
                System.out.println(num + " is an odd number.");
            }

            boolean isPrime = mciq.isPrime(num);
            if(isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }

            int lb = 10;
            int ub = 100;
            int count = mciq.countPrimeInRange(lb, ub);
            System.out.println("Number of prime numbers between " + lb + " and " + ub + " is: " + count);
    }
}
