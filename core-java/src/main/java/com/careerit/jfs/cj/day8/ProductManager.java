package com.careerit.jfs.cj.day8;

public class ProductManager {
    public static void main(String[] args) {

        Product product = new Product(1, "Laptop", 50000.0);
        product.showDetails();


        System.out.println("------------------");

        Product product1 = new Product(2, "Mobile", 30000.0);
        product1.showDetails();


    }
}
