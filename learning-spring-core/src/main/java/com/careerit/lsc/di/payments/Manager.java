package com.careerit.lsc.di.payments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.lsc.di.payments")
public class Manager {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
        ConfirmOrderService confirmOrderService = context.getBean(ConfirmOrderService.class);
        confirmOrderService.confirmOrder();

    }
}
