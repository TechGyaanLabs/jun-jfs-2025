package com.careerit.jfs.cj.day26.country;

public class ProductManager {

    public static void main(String[] args) {

        Product p1 =
                Product.builder()
                        .name("Laptop")
                        .price(50000)
                        .category("Electronics")
                        .build();
        System.out.println(p1);

        Product p2 =
                Product.builder()
                        .name("Mobile")
                        .price(15000)
                        .category("Electronics")
                        .inStock(false)
                        .discount(1000)
                        .build();
        System.out.println(p2);
        System.out.println(p2);

    }
}
