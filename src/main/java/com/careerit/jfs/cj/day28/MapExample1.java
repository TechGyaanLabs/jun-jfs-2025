package com.careerit.jfs.cj.day28;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample1 {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        // put
        map.put("John",100);
        map.put("Charan",200);
        map.put("Naidu",500);
        map.put("John",600);

        System.out.println(map);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        System.out.println(keys);
        System.out.println(values);

        // Iterate over map
        for(String key : keys){
            System.out.println(key + " : " + map.get(key));
        }
        // Process map elements
        map.forEach((String key, Integer value) -> System.out.println(key + " : " + value));
    }
}
