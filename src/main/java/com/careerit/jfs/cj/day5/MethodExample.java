package com.careerit.jfs.cj.day5;

import java.time.LocalDate;

public class MethodExample {

    public static void main(String[] args) {
        int num = 10;
        int res = sumOfNaturalNumbers(num);
        System.out.println("Sum of first " + num + " natural numbers is: " + res);

        int num1 = 10, num2 = 20, num3 = 30;
        int biggest = biggestOfThree(num1, num2, num3);
        System.out.println("Biggest of " + num1 + ", " + num2 + ", and " + num3 + " is: " + biggest);

        LocalDate currentDate = getCurrentDate();
        System.out.println("Current date is: " + currentDate);

        String osName = getOperatingSystemName();
        System.out.println("Operating system name is: " + osName);

        printGreeting("John");
        showJavaVersion();


    }

    // Method with return type with parameters
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int biggestOfThree(int a, int b, int c) {
       return Math.max(a, Math.max(b, c));
    }

    // Method with return type without parameters
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
    public static String getOperatingSystemName() {
        return System.getProperty("os.name");
    }

    // Method without return type with parameters
    public static void printGreeting(String username) {
        System.out.println("Hello, " + username + "! Welcome to the Java programming world.");
    }

    // Method without return type without parameters
    public static void showJavaVersion() {
        System.out.println("Java version: " + System.getProperty("java.version"));
    }
}
