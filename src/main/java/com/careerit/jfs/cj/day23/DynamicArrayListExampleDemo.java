package com.careerit.jfs.cj.day23;

import java.util.ArrayList;
import java.util.List;

class DynamicArrayList {

    private List<Object> list = new ArrayList();

    public void add(Object ele) {
        list.add(ele);
    }

    public Object get(int index) {
      return list.get(index);
    }

    public void showElements() {
        if(list.size() == 0){
            System.out.println("Array is empty");
            return;
        }else {
            for (Object ele : list) {
                System.out.print(ele + " ");
            }
        }
    }

    public boolean delete(int pos) {
        return list.remove(pos) != null;
    }
}

public class DynamicArrayListExampleDemo {

    public static void main(String[] args) {
        DynamicArrayList ref = new DynamicArrayList();
        ref.add("1");
        ref.add("2");
        ref.add("3");

        ref.delete(2);
        ref.delete(1);
        ref.delete(0);
        ref.showElements();

        ref.add("1");
        ref.add("2");
        ref.add("3");
        ref.add("4");
        ref.add("5");
        ref.add("4");
        ref.add("5");
        ref.add("4");
        ref.add("5");
        ref.showElements();
    }
}
