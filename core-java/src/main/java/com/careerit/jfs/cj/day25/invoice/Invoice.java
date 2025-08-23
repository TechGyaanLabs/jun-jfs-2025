package com.careerit.jfs.cj.day25.invoice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Invoice {
    private String invoiceId;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private String currency;
    private String status;
    private Party sender;
    private Party recipient;
    private List<Item> items;
    private double subtotal;
    private double taxTotal;
    private double grandTotal;
    private String notes;
    private String terms;


}
