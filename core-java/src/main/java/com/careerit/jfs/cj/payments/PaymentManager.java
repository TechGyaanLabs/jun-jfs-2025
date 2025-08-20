package com.careerit.jfs.cj.payments;

public class PaymentManager {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        PaymentProcessor paymentProcessor = paymentService.getPaymentProcessor();
        paymentProcessor.processPayment(100);
    }
}
