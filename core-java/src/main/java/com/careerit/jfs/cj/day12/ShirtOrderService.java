package com.careerit.jfs.cj.day12;


enum Color{
    RED,
    GREEN,
    BLUE,
    YELLOW,
    WHITE
}
enum Size{
    SMALL,
    MEDIUM,
    LARGE
}
public class ShirtOrderService {

    public static void main(String[] args) {
            orderShirt(Color.BLUE, Size.LARGE);
    }
    public static void orderShirt(Color color, Size size) {
        System.out.println("Color is: " + color);
        System.out.println("Size is: " + size);
    }
}
