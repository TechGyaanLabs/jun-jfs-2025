package com.careerit.jfs.cj.day10;

public class ProductManager {

    public static void main(String[] args) {

        String productData = " P0011-iPhone 16 Pro Max-150000 ,P0022-iPhone 16 Pro-120000 ,P0033-iPhone 15-100000, P0044-iPhone 14-80000, P0055-iPhone 13-60000 ";
        String[] productDetails = productData.split(",");
        Product[] products = new Product[productDetails.length];

        for (int i = 0; i < productDetails.length; i++) {
            String data = productDetails[i].trim(); // "P0011-iPhone 16 Pro Max-150000"
            String[] arr = data.split("-");
            String pid = arr[0].trim(); // "P0011"
            String name = arr[1].trim(); // "iPhone 16 Pro Max"
            double price = Double.parseDouble(arr[2].trim()); // "150000"

            Product p = new Product(pid,name,price);
            products[i] = p;
        }

        System.out.println(products.length);

        for(Product p : products) {
            p.showDetails();
            System.out.println("----------------------------------");
        }
    }
}
