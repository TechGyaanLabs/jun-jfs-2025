package com.careerit.jfs.cj.day16;

import java.time.LocalDate;
import java.time.LocalTime;

class Car{

    private String model;
    private String color;
    private int year;

    public Car(String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }

}

class Appointment{

        private String doctor;
        private String patient;
        private int age;
        private LocalDate date;
        private LocalTime time;
        private String description;
        private String location;

        public Appointment(String doctor, String patient, int age, LocalDate date, LocalTime time, String description, String location){
            this.doctor = doctor;
            this.patient = patient;
            this.age = age;
            this.date = date;
            this.time = time;
            this.description = description;
            this.location = location;
        }

}

class Person{
    private String name;
    private double salary;
    private String city;
    private String qualification;
    private String email;
    private String mobile;

    public Person(String name, String email, String mobile){
        this(name,email,mobile,"N/A","N/A",0.0);
    }

    public Person(String name, String email, String mobile,String city){
       this(name,email,mobile,city,"N/A",0.0);
    }

    public Person(String name, String email, String mobile,String city,String qualification){
        this(name,email,mobile,city,qualification,0.0);
    }

    public Person(String name, String email, String mobile,String city,String qualification,double salary){
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.qualification = qualification;
        this.salary = salary;
    }




    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("City: " + city);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: " + salary);
    }
}

public class ThisAndSuperKeywords {

    public static void main(String[] args) {
            Person p1 = new Person("Rahul", "rahul@gmail.com", "9876545673");
            p1.showDetails();
    }
}