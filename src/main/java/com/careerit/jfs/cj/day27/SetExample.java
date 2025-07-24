package com.careerit.jfs.cj.day27;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("John");
        set.add("John");
        set.add("Krishna");
        set.add("Krishna");
        System.out.println(set);
    }
}
