package com.careerit.lsc.di.payments;

import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    public void generateInvoice() {
        System.out.println("Invoice generated");
    }
}
