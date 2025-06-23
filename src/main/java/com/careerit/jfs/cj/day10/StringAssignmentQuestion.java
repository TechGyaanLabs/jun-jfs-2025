package com.careerit.jfs.cj.day10;


class Student{
    private String name;
    private int age;
    private double height;
    private String mobile;

    public Student(String name, int age, double height, String mobile) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.mobile = mobile;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Mobile: " + mobile);
    }
}
public class StringAssignmentQuestion {


    public static void main(String[] args) {

        String data ="liril,john,malayalam,java,python,mom,dad,radar,.Net";
        String[] palindromeArr = getPalindromes(data);

        String studentData ="Krish-30- 5.6 -1234567890 ,Manoj-25-5.5- 1234567891 ,Praveen-30-5.5-1234567892,Ramesh- 30 -5.5- 1234567893";

        // Convert studentData to Student array and display student details by calling showDetails method on each student


    }

    private static String[] getPalindromes(String data) {
        return null;
    }
}
