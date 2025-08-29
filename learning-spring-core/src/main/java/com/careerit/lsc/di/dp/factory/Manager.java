package com.careerit.lsc.di.dp.factory;

public class Manager {

    public static void main(String[] args) {


            Notification notification = NotificationFactory.getInstance(NotificationType.SMS);
            notification.notifyUser();



    }
}
