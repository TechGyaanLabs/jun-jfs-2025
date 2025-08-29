package com.careerit.lsc.di.dp.factory;

public class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}