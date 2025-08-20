package com.careerit.jfs.cj.reflection;

public class Invoice {
    private String invoiceNo;
    private String customerName;
    private double totalAmount;

    public Invoice(String invoiceNo, String customerName, double totalAmount) {
        this.invoiceNo = invoiceNo;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public void showDetails() {
        System.out.println("Invoice No : " + invoiceNo);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Total Amount : " + totalAmount);
    }
}
