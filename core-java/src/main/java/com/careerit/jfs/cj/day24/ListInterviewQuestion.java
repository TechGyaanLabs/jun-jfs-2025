package com.careerit.jfs.cj.day24;

import java.util.ArrayList;
import java.util.List;

public class ListInterviewQuestion {

    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.remove(0);
        list.remove(1);
        list.remove(Integer.valueOf(20));
        System.out.println(list);
    }
}
