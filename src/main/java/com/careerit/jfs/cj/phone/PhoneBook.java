package com.careerit.jfs.cj.phone;
import java.util.*;

public class PhoneBook {
    static Map<String, String> map = new HashMap<>();

    public static void addDetails(String phno, String name){
        map.put(phno, name);
        System.out.println("Entry added successfully");
    }

    public String getName(String phno){
        if (map.containsKey(phno)){
            return map.get(phno);
        }else {
            return "Sorry! No person found with the given number.";
        }
    }
}
