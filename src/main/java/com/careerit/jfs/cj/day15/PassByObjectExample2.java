package com.careerit.jfs.cj.day15;

class Product{
    String pid;
    String name;
    double price;
    double discount;
    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.discount = 0;
    }

    public void updateDiscount(Product product, double discount) {
        product.discount = discount;
    }
    public void showDetails() {
        System.out.println("Product id: " + pid);
        System.out.println("Product name: " + name);
        System.out.println("Product price: " + price);
        System.out.println("Product discount: " + discount);
    }
}
public class PassByObjectExample2 {

    public static void main(String[] args) {
            Product product = new Product("P0011", "iPhone 16 Pro Max", 150000.0);
            product.showDetails();

            product.updateDiscount(product, 10000.0);
            product.showDetails();
    }
}
