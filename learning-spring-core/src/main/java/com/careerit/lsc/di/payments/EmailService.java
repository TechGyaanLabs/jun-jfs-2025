package com.careerit.lsc.di.payments;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail() {
        System.out.println("Email sent");
    }
}
