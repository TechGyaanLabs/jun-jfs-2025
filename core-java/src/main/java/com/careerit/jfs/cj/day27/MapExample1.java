package com.careerit.jfs.cj.day27;

import java.util.HashMap;
import java.util.Map;

public class MapExample1 {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        map.put("John",100);
        map.put("Charan",200);
        map.put("Naidu",500);
        map.put("John",600);

        System.out.println(map);
        System.out.println(map.get("Charan"));

        int value = map.get("Charan");
        map.put("Charan",value+500);
        System.out.println(map);

        // Get Krish value if not present put value 500 if present add 1000 to existing value

        if(map.containsKey("Krish")){
            map.put("Krish",map.get("Krish")+1000);
        }else{
            map.put("Krish",500);
        }
        System.out.println(map);

    }
}
