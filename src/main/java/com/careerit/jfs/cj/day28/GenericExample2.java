package com.careerit.jfs.cj.day28;

class Box<T>{
    private T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }
}
public class GenericExample2 {

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setItem("Pen");
        System.out.println(box.getItem());
    }

}
