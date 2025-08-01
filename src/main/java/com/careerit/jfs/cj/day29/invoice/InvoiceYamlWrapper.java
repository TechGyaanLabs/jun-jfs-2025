package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InvoiceYamlWrapper {
    private Invoice invoice;
    private Customer customer;
    private Biller biller;
    private List<InvoiceItem> items;
    private PaymentTerms payment_terms;
    private Shipping shipping;
    private Metadata metadata;
} 