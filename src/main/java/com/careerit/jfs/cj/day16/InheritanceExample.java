package com.careerit.jfs.cj.day16;

class Animal{

    public void sound(){
        System.out.println("Animal make some souund");
    }
}

class Dog extends Animal {

    public void sound(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {

    public void sound(){
        System.out.println("Cat meows");
    }
}

public class InheritanceExample {
}
