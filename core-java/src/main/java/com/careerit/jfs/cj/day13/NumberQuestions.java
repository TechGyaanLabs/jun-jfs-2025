package com.careerit.jfs.cj.day13;

public class NumberQuestions {

    public int[] getPrimeNumberInRange(int lb, int ub){
        int[] arr = new int[primeCountInRange(lb, ub)];
        int index = 0;
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                arr[index++] = i;
            }
        }
        return arr;
    }

    private boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    private int primeCountInRange(int lb, int ub){
        int count = 0;
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
}
