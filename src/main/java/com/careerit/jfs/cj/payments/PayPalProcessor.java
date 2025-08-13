package com.careerit.jfs.cj.payments;

public class PayPalProcessor implements PaymentProcessor {
    public PayPalProcessor() { }
    @Override
    public void processPayment(double amount) {

        System.out.println("Processing PayPal payment: $" + amount);
    }
}


