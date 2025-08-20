package com.careerit.jfs.cj.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListExample2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        // Generate 20 unique random numbers in range 10 to 50 and display them.
        while(list.size() < 20) {
            int num = ThreadLocalRandom.current().nextInt(10, 51);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        System.out.println("Total numbers: " + list.size());
        System.out.println(list);
    }
}
