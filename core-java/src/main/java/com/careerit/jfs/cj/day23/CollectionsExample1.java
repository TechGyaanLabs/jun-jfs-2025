package com.careerit.jfs.cj.day23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionsExample1 {

    public static void main(String[] args) {

        // Generate 20 unique random numbers in range 1 to 100
        int count = 20;
        Set<Integer> set = new HashSet<>();
        while(set.size() < count){
            int num = ThreadLocalRandom.current().nextInt(1, 101);
            set.add(num);
        }
        System.out.println(set);
    }
}
