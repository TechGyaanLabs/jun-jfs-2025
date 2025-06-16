package com.careerit.jfs.cj.day7;

class Employee {
     private String name;
     private int age;
     private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        if(salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;

    }
    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

public class ConstructorExample {

    public static void main(String[] args) {

            Employee emp1 = new Employee("Krish", 25, 50000.0);
            emp1.showDetails();

            Employee emp2 = new Employee("Manoj", 30, 60000.0);
            emp2.showDetails();
    }
}
