package com.careerit.jfs.cj.day8;

public class Product {

    private long id;
    private String name;
    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void showDetails() {
        System.out.println("Product id: " + id);
        System.out.println("Product name: " + name);
        System.out.println("Product price: " + price);
    }

}
