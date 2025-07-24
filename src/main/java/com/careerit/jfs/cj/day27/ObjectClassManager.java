package com.careerit.jfs.cj.day27;

import java.util.Objects;

class Student{
    private String name;
    private int age;
    private String country;

    public Student(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(country, student.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, country);
    }
}

public class ObjectClassManager {

    public static void main(String[] args) {

        Student s1 = new Student("John", 20, "USA");
        Student s2 = new Student("John", 20, "USA");

        System.out.println(s1 == s2); // == operator compares the reference address
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));

    }
}
