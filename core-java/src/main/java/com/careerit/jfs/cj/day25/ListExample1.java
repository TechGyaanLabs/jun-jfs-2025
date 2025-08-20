package com.careerit.jfs.cj.day25;

import com.careerit.jfs.cj.day13.one.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ListExample1 {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Get all the number which are divisible by 3

        /*List<Integer> divisibleBy3 = new ArrayList<>();
        for (Integer num : list) {
            if (num % 3 == 0) {
                divisibleBy3.add(num);
            }
        }*/
        List<Integer> divisibleBy3 = list.stream()
                .filter(num -> num % 3 == 0)
                .toList();
        System.out.println(divisibleBy3);

        List<String> names = List.of("John", "Charan","Mahesh","Kishore","Naidu","James");

      /*  List<Integer> namesLength = new ArrayList<>();
        for (String name : names) {
            namesLength.add(name.length());
        }*/

        List<Integer> namesLength = names.stream()
                .map(String::length)
                .toList();

        System.out.println(namesLength);

        String data = "learning java is fun to have fun learn java in fun way";
        /*String[] arr = data.split(" ");
        List<String> words = new ArrayList<>();
        for (String word : arr) {
            if(!words.contains(word)){
                words.add(word);
            }
        }*/

        List<String> words = Stream.of(data.split(" "))
                        .distinct()
                        .toList();

        System.out.println(words);

    }
}
