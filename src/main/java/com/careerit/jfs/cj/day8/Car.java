package com.careerit.jfs.cj.day8;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("You have started " + name);
    }

    public void play() {
        System.out.println("You have played " + name);
    }

    public void stop() {
        System.out.println("You have stopped " + name);
    }

}