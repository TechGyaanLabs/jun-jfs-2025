package com.careerit.jfs.cj.day27;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals method is called");
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Hashcode method is called");
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               '}';
    }
}

public class SetExample1 {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone 16 Pro Max");
        Product p2 = new Product("iPhone 16 Pro Max");
        Product p3 = new Product("iPhone 16 Pro Max");
        Product p4 = new Product("iPhone 17 Pro Max");

        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        System.out.println(products.size());

        for(Product p : products) {
            System.out.println(p);
        }

        products.forEach(System.out::println);

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
