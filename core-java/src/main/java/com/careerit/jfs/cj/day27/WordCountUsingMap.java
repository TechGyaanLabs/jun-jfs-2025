package com.careerit.jfs.cj.day27;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCountUsingMap {

    public static void main(String[] args) {

        String data = "learning java is fun to have fun learn java in fun way and java is fun to learn";

        String[] words = data.split(" ");
        System.out.println(Arrays.toString(words));

        Map<String,Integer> map = new HashMap<>();

        for(String word : words){
            map.computeIfAbsent(word, k -> 0);
            map.put(word,map.get(word)+1);
        }
        System.out.println(map);
    }
}
