package com.careerit.lsc.di.payments;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void makePayment() {
        System.out.println("Payment made");
    }
}
