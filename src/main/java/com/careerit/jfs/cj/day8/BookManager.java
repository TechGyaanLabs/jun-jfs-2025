package com.careerit.jfs.cj.day8;

class Book{

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void calculateDiscount(double discount) {
        this.price = price - (price * discount);
    }

    public void showDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

}
public class BookManager {

    public static void main(String[] args) {

        // Create 5 book objects and store in an array and print details of all books

        // Provide discount of 10% for all books then display details of all books


    }
}
