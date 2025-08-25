package com.careerit.lsc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingManager {



    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("greetings-beans.xml");
        GreetingService greetingService = context.getBean(GreetingService.class);
        String message = greetingService.greeting("Ramesh");
        System.out.println(message);

    }

}
