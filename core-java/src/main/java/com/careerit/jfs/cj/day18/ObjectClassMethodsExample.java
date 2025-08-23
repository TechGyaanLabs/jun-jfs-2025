package com.careerit.jfs.cj.day18;

class Employee extends  Object{

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString(){
        return "Name: " + name + ", Salary: " + salary;
    }

}

public class ObjectClassMethodsExample {

    public static void main(String[] args) {

        Employee emp = new Employee("Krish", 150000.0);
        System.out.println(emp.toString());

    }
}
