package com.careerit.jfs.cj.payments;

import java.util.Properties;

public class PaymentService {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(PaymentService.class.getResourceAsStream("/payment.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PaymentProcessor getPaymentProcessor() {
        PaymentProcessor paymentProcessor = null;
        try {
            String paymentProcessorClass = properties.getProperty("payment.processor");
            paymentProcessor = (PaymentProcessor) Class.forName(paymentProcessorClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentProcessor;
    }

}
