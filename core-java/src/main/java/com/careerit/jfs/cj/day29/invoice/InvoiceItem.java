package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvoiceItem {
    private String id;
    private String name;
    private String description;
    private int quantity;
    private double unit_price;
    private double total;
    private String category;
} 