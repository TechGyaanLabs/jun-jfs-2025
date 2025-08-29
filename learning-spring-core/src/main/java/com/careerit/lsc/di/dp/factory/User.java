package com.careerit.lsc.di.dp.factory;

import lombok.Builder;

@Builder
class User {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;

    public void showDetails() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
    public static void main(String[] args) {
        User user = User.builder().firstName("John")
                .lastName("Doe")
                .age(12)
                .phone("123456789")
                .address("12345")
                .build();
        user.showDetails();
    }
}