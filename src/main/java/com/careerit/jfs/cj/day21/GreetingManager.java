package com.careerit.jfs.cj.day21;

interface GreetingService{
    String greet(String name);
}

interface MessageService{
    void sendMessage(String message,String to);
}
// Implement BirthdayGreetingService, AnniversaryGreetingService, NewYearGreetingService and SessionGreetingService

// Implement MessageService using EmailMessageService, SMSMessageService and WhatsappMessageService

class GreetingSender{


        public void sendGreeting(GreetingService greetingService, MessageService messageService, String name) {

        }
}
public class GreetingManager {

    public static void main(String[] args) {
        GreetingSender sender = new GreetingSender();

    }
}
