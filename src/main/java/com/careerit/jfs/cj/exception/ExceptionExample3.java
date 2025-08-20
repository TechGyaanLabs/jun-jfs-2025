package com.careerit.jfs.cj.exception;

public class ExceptionExample3 {

    public static void main(String[] args) {
        try {
            System.out.println(10 / 2);
            String name = "Krish";
            System.out.println(name.length());
            System.out.println(name.charAt(10));
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed");
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        } catch (Exception e) {
            System.out.println("Generic Exception handler " + e);
        } finally {
            System.out.println("finally block");
        }
    }
}
