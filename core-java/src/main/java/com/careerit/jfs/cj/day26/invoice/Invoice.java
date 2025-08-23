package com.careerit.jfs.cj.day26.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
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
