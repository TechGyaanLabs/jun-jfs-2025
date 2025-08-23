package com.careerit.jfs.cj.day12;

public enum PaymentStatus {

    PENDING("Payment is pending"),
    COMPLETED("Payment is completed"),
    FAILED("Payment is failed");


    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


    public static void main(String[] args) {

           PaymentStatus[] paymentStatuses = PaymentStatus.values();

           for (PaymentStatus paymentStatus : paymentStatuses) {
               System.out.println(paymentStatus);
               System.out.println(paymentStatus.getDescription());
           }

           String str = "COMPLETED";
           PaymentStatus paymentStatus = PaymentStatus.valueOf(str);
           System.out.println(paymentStatus+" "+paymentStatus.description);
    }

}
