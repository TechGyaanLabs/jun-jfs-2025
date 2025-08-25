package com.careerit.lsc.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactManager {

    public static void main(String[] args) {

            ApplicationContext context = new ClassPathXmlApplicationContext("contacts-beans.xml");
            ContractController contractController = context.getBean(ContractController.class);
            long count = contractController.getActivateContacts();
            System.out.println(count);
    }
}
