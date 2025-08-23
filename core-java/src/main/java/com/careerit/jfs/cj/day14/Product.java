package com.careerit.jfs.cj.day14;

import java.util.List;

public class Product {

    private String pid;
    private String name;
    private double price;
    private String description;
    private static int count = 0;

    // Instance initializer Block (IIB)
    {
        System.out.println("Product is created");
        count++;
    }

    public Product(String pid, String name, String description, double price) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public Product(String pid, String name) {
        this.pid = pid;
        this.name = name;
        this.price = 0;
        this.description = "";

    }

    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.description = "";

    }

    public void showDetails() {
        System.out.println("Id           : " + pid);
        System.out.println("Name.        : " + name);
        System.out.println("Price.       : " + price);
        System.out.println("Description  : " + description);
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {

        System.out.println(Product.getCount());

        Product product = new Product("P0011", "iPhone 16 Pro Max", 150000.0);
        Product product1 = new Product("P0022", "iPhone 16 Pro","iPhone 16 Pro with 256 GB", 120000.0);
        Product product2 = new Product("P0033", "iPhone 15");
        Product product3 = new Product("P0044", "iPhone 14", 80000.0);
        Product product4 = new Product("P0055", "iPhone 13", 60000.0);

        List<Product> products = List.of(product, product1, product2, product3, product4);

        for (Product p : products) {
            p.showDetails();
            System.out.println("----------------------------------");
        }

        System.out.println(Product.getCount());

    }


}
