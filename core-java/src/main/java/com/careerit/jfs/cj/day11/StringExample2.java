package com.careerit.jfs.cj.day11;

public class StringExample2 {

    public static void main(String[] args) {
        String name = "Krish";
        int age = 25;
        double height = 5.5;
        String mobile = "9876543210";
        double salary = 50000.0;

        /**
         * Hi Krish, your age is 25, your height is 5.5, your mobile number is 9876543210 and your salary is 50000.0
         * can you please confirm your details?
         */

        String message = """
                Hi %s,
                    Below are your details,
                        Age is %s,
                        Height is %s,
                        Mobile number is %s,
                        Salary is %s
                    can you please confirm your details?
                """
                .formatted(name, age, height, mobile, salary);

        System.out.println(message);
    }
}
