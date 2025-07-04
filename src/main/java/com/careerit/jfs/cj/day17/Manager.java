package com.careerit.jfs.cj.day17;

class Shape {
    public void draw() {
        System.out.println("Drawing Shape");
    }
}
class Rectangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Rectangle {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

enum ShapeType {
    RECTANGLE, CIRCLE, SQUARE
}

public class Manager {

    public static void main(String[] args) {
            Shape shape = getShape(ShapeType.CIRCLE);
            shape.draw();
    }

    public static Shape getShape(ShapeType shapeType) {
            return switch (shapeType) {
                case RECTANGLE -> new Rectangle();
                case CIRCLE -> new Circle();
                case SQUARE -> new Square();
            };
    }
}
