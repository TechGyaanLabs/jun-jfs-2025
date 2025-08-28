package com.careerit.lsc.di.payments;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmOrderService {

    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final EmailService emailService;

    public void confirmOrder() {
        paymentService.makePayment();
        invoiceService.generateInvoice();
        emailService.sendEmail();
    }
}
