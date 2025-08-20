package com.careerit.jfs.cj.day19;

import java.util.Arrays;

interface NumberOperation{
    boolean isPrime(int num);
    default int primeCountInRange(int lb, int ub){
        int count = 0;
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    default int[] getPrimeNumberInRange(int lb, int ub){
        int[] arr = new int[primeCountInRange(lb, ub)];
        int index = 0;
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                arr[index++] = i;
            }
        }
        return arr;
    }
    default int[] getRandom20PrimeNumber(){
        int[] arr = new int[20];
        int index = 0;
        while(index < 20){
            int num = (int) (Math.random() * 100000);
            if(isPrime(num)){
                arr[index++] = num;
            }
        }
        return arr;
    }
}
class PrimeNumber implements NumberOperation{
    @Override
    public boolean isPrime(int num) {
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
}
public class InterfaceExample3 {

    public static void main(String[] args) {
        NumberOperation ref = new PrimeNumber();
        System.out.println(ref.isPrime(13));
        System.out.println(Arrays.toString(ref.getPrimeNumberInRange(10, 100)));

    }
}
