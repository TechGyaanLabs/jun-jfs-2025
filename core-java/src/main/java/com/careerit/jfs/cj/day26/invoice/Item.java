package com.careerit.jfs.cj.day26.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
    private String description;
    private int quantity;
    private double unitPrice;
    private double taxRate;
    private double total;


}