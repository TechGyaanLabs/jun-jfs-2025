package com.careerit.jfs.cj.day2;

public class MangoArrangementService {

    public static void main(String[] args) {
        int mangoes = 29474;
        int boxCapacity = 25;
        int boxesRequired;
        if(mangoes % boxCapacity == 0) {
            boxesRequired = mangoes / boxCapacity;
        }else{
            boxesRequired = mangoes / boxCapacity + 1;
        }
        System.out.println("Boxes required to arrange " + mangoes + " mangoes with capacity of " + boxCapacity + " is: " + boxesRequired);
    }

}
