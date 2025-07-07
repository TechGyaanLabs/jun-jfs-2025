package com.careerit.jfs.cj.day18;



abstract class Shape{
    public abstract double area();
}
class Circle extends Shape{
    int r;
    public Circle(int r){
        this.r = r;
    }
    @Override
    public double area() {
        return Math.PI * r * r;
    }
}
class Rectangle extends Shape{
    int l,b;
    public Rectangle(int l,int b){
        this.l = l;
        this.b = b;
    }
    @Override
    public double area() {
        return l * b;
    }
}

class Square extends Shape{
    int s; // side
    public Square(int s){
        this.s = s;
    }
    @Override
    public double area() {
        return s * s;
    }
}

class Triangle extends Shape{
    int b,h;
    public Triangle(int b,int h){
        this.b = b;
        this.h = h;
    }
    @Override
    public double area() {
        return 0.5 * b * h;
    }
}



public class AbstractClassExample {

    public static void main(String[] args) {

            Shape shape = new Triangle(4,5);
            double area = shape.area();
            System.out.println("Area: " + area);
    }
}
