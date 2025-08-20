package com.careerit.jfs.cj.day20;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

interface NumberOperations {

    static int monthsBetween(LocalDate fromDate, LocalDate toDate) {
        Period period = Period.between(fromDate, toDate);
        int months = period.getYears() * 12 + period.getMonths();
        if (period.getDays() >= 15) {
            months++;
        }
        return months;
    }

    static int dayInGivenMonth(int year, int month){
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 ->  31;
            case 2 -> {
                if (isLeapYear(year)) {
                   yield  29;
                } else {
                   yield  28;
                }
            }
            default -> 30;
        };

    }

    private static boolean isLeapYear(int year){
        return year % 16 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    default int[] getPrimeInRange(int lb, int ub) {
        int count = countPrimeInRange(lb, ub);
        int[] arr = new int[count];
        int index = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                arr[index++] = i;
            }
        }
        return arr;
    }

    private int countPrimeInRange(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class PrimeNumberService implements NumberOperations {

}

public class InterfaceExample1 {

    public static void main(String[] args) {

        NumberOperations ref = new PrimeNumberService();
        int[] arr = ref.getPrimeInRange(10, 30);
        System.out.println(Arrays.toString(arr));

        int months = NumberOperations.monthsBetween(LocalDate.now()
                .minusMonths(120)
                .minusDays(1)
                .minusMonths(1), LocalDate.now());
        System.out.println(months);
    }
}
