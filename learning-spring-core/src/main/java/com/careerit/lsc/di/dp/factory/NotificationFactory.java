package com.careerit.lsc.di.dp.factory;

public class NotificationFactory {

    public static Notification getInstance(NotificationType type) {
        return
                switch (type) {
                    case NotificationType.SMS -> new SMSNotification();
                    case NotificationType.EMAIL -> new EmailNotification();
                    case NotificationType.PUSH -> new PushNotification();
                    default -> throw new IllegalArgumentException("Unknown NotificationType");
                };
    }
}