package com.careerit.jfs.cj.day24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListExample1 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(60);
        list2.add(50);
        list2.add(70);

        List<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(80);
        list3.add(90);
        list3.add(50);
        list3.add(100);

        List<Integer> list4 = new ArrayList<>();
        list4.addAll(list1);
        list4.addAll(list2);
        list4.addAll(list3);
        System.out.println(list4);
        System.out.println(list4.size());
        System.out.println(list4.get(4));
        System.out.println(list4.getFirst());
        System.out.println(list4.get(0));
        System.out.println(list4.getLast());
        System.out.println(list4.get(list4.size() - 1));

        // Iterate over the list using traditional for loop
        System.out.println(list4);
        for (int i = 0; i < list4.size(); i++) {
           System.out.print(list4.get(i) + " ");
        }
        System.out.println("List after removing elements "+list4);
        System.out.println("\n\nUsing for-each loop\n");
        // Iterate over the list using for-each loop
        for (Integer ele : list4) {
            System.out.print(ele + " ");
        }

        System.out.println("\n\nUsing Iterator\n");

        Iterator<Integer> itr = list4.iterator();
        while (itr.hasNext()) {
            int ele = itr.next();
            if(ele % 15 == 0){
                itr.remove();
            }
            System.out.print(ele + " ");
        }
        System.out.println("\n"+list4);


        ListIterator<Integer> litr = list4.listIterator();
        System.out.println("\n\nUsing ListIterator\n");
        while (litr.hasNext()) {
            int ele = litr.next();
            if(ele == 10){
                litr.set(1000);
            }
            if(ele == 50){
                litr.remove();
            }
            if(ele == 30){
                litr.add(3000);
            }
            System.out.print(ele + " ");
        }

        System.out.println("\n\nUsing ListIterator in reverse order\n");
        while (litr.hasPrevious()) {
            int ele = litr.previous();
            System.out.print(ele + " ");
        }

        // Using Streams
        System.out.println("\n\nUsing Streams\n");
        list4.forEach(e-> System.out.print(e + " "));
    }
}
