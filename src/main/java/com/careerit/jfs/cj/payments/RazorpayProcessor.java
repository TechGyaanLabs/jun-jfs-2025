package com.careerit.jfs.cj.payments;

public class RazorpayProcessor implements PaymentProcessor {

    public RazorpayProcessor() {}
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Razorpay payment: $" + amount);
    }
}
