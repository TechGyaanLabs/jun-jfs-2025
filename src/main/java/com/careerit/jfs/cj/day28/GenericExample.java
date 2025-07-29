package com.careerit.jfs.cj.day28;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("John");

        for(String name : list){
            System.out.println(name);
        }
    }


}
