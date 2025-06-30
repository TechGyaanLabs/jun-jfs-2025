package com.careerit.jfs.cj.day14;

class Sample {
    static int count = 0;
    {
        System.out.println("Instance initializer block - 1 called");
        count++;
        System.out.println("Count value: " + count);
    }

    public Sample() {
        System.out.println("Constructor called");
    }

    public Sample(String message) {
        System.out.println(message);
    }

    public Sample(String username, String message) {
        System.out.println("Hello " + username);
        System.out.println(message);

    }


}

public class InstanceInitializerBlockExample {

    public static void main(String[] args) {
        System.out.println("Start of main method");
        Sample sample = new Sample();
        Sample sample1 = new Sample("Hello");
        Sample sample2 = new Sample("User", "HelloWorld");
        System.out.println("End of main method");
    }
}
