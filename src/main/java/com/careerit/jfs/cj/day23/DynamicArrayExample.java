package com.careerit.jfs.cj.day23;

import java.util.Arrays;

class DynamicArray {

    private Object[] arr;
    private int index;

    public DynamicArray(int size) {
        arr = new Object[size];
        index = 0;
    }

    public void add(Object ele) {
        if (index < arr.length) {
            arr[index++] = ele;
        } else {

            Object[] temp = new Object[arr.length == 0 ? 1 : arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
            arr[index++] = ele;
        }
    }

    public Object get(int index) {
        return arr[index];
    }

    public void showElements() {
        System.out.println("Array size is " + arr.length);
        if(index == 0){
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public boolean delete(int pos) {

        if(pos < 0 || pos > index){
            return false;
        }

        if(pos == 0){
            Object[] temp = new Object[arr.length-1];
            System.arraycopy(arr,1,temp,0,arr.length-1);
            arr = temp;
            index--;
            System.out.println("Deleted successfully " + Arrays.toString(arr));
            return true;
        }else if(pos == index-1){
            Object[] temp = new Object[arr.length-1];
            System.arraycopy(arr,0,temp,0,pos);
            arr = temp;
            index--;
            return true;
        }else{
            Object[] temp = new Object[arr.length-1];
            System.arraycopy(arr,0,temp,0,pos);
            System.arraycopy(arr,pos+1,temp,pos,arr.length-pos-1);
            arr = temp;
            index--;
            return true;
        }
    }
}

public class DynamicArrayExample {

    public static void main(String[] args) {
        DynamicArray ref = new DynamicArray(3);
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
