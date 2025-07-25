package com.careerit.jfs.cj.day28;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamExample1 {

    public static void main(String[] args) {

        String data = "John,Charan,Naidu,Ramesh,Krishna,Manoj,Praveen,Jagan,Pavan,Krishna,Ramesh,Suresh";

        String[] names = data.split(",");

        List<String> uniqueNames = Stream.of(names).distinct().toList();
        System.out.println(uniqueNames);

        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 20; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(10, 50));
        }
        System.out.println(numbers);

        // Get the numbers which are divisible by 5

        /*List<Integer> divisibleBy5 = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 5 == 0) {
                divisibleBy5.add(num);
            }
        }*/
        List<Integer> divisibleBy5 = numbers.stream()
                .filter(num -> num % 5 == 0)
                .toList();
        System.out.println(divisibleBy5);

        // Increment all the numbers by 1
        List<Integer> incrementedNumbers = numbers.stream()
                                            .map(num -> num + 1)
                                            .toList();
        System.out.println(incrementedNumbers);
    }
}
