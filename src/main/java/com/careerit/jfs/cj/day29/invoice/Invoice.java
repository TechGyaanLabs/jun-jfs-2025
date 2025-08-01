package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Invoice {
    private String invoice_number;
    private String date;
    private String due_date;
    private String status;
    private String currency;
    private double subtotal;
    private double tax_rate;
    private double tax_amount;
    private double discount_rate;
    private double discount_amount;
    private double total_amount;
    private String notes;
} 