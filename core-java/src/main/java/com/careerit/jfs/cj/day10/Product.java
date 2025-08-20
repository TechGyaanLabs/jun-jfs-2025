package com.careerit.jfs.cj.day10;

public class Product {

    private String pid;
    private String name;
    private double price;


    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product id: " + pid);
        System.out.println("Product name: " + name);
        System.out.println("Product price: " + price);
    }
}
