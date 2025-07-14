package com.careerit.jfs.cj.day22;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        MyFunction add = (num1, num2) -> num1 + num2;
        MyFunction sub = (num1, num2) -> {
            if (num1 > num2) {
                return num1 - num2;
            } else {
                return num2 - num1;
            }
        };
        MyFunction mul = (num1, num2) -> num1 * num2;
        MyFunction div = (num1, num2) -> num1 / num2;
        System.out.println(add.apply(10, 20));
        System.out.println(sub.apply(10, 20));
        System.out.println(mul.apply(10, 20));
        System.out.println(div.apply(10, 20));

        BinaryOperator<Integer> add1 = (num1, num2) -> num1 + num2;
        System.out.println(add1.apply(10, 20));

        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println(isEven.test(10));
    }
}
