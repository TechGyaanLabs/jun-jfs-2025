package com.careerit.jfs.cj.payments;

public class StripeProcessor implements PaymentProcessor {
    public StripeProcessor() { }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment: $" + amount);
    }
}