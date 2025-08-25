package com.careerit.lsc.di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.lsc.di.java")
public class ContactManager {

    public static void main(String[] args) {

            ApplicationContext context = new AnnotationConfigApplicationContext(ContactManager.class);
            ContractController contractController = context.getBean(ContractController.class);
            long count = contractController.getActivateContacts();
            System.out.println(count);
    }
}
