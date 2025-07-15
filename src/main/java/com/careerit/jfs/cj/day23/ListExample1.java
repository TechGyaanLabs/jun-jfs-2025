package com.careerit.jfs.cj.day23;

import java.util.ArrayList;
import java.util.List;

public class ListExample1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Krishna");
        list.add("Rajesh");
        list.add("Suresh");
        // Add in 1st position Johe Doe
        String str = "";
        for (String s : list) {
            str = str.concat(s);
        }
        System.out.println(str);
        System.out.println(list);
        list.add(1, "John Doe");
        list.add(3, "Naidu");
        System.out.println(list);

        // Can  you add element Before Naidu and element is "Jagan"

        int index = list.indexOf("Naidu");
        if(index != -1){
            list.add(index, "Jagan");
        }
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(3));
        System.out.println(list.size());

        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }

        // Get element is reverse order
        System.out.println("Reverse order");
        for(int i = list.size() - 1;i >= 0;i--){
            System.out.println(list.get(i));
        }

        // Remove "Rajesh if present"
        if(list.contains("Rajesh")){
            list.remove("Rajesh");
        }
        System.out.println(list);
        list.clear();
        System.out.println(list.isEmpty());

    }
}
