package com.careerit.jfs.cj.day8;



public class CarManager {

    public static void main(String[] args) {

        Car car1 = new Car("BMW");
        car1.start();
        car1.play();
        car1.stop();

        System.out.println("------------------");
        Car car2 = new Car("Audi");
        car2.start();
        car2.play();
        car2.stop();


    }
}
