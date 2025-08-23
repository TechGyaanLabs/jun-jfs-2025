package com.careerit.jfs.cj.day25.invoice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String description;
    private int quantity;
    private double unitPrice;
    private double taxRate;
    private double total;


}