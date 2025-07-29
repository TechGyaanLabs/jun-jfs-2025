package com.careerit.jfs.cj.day28;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

            Stack<String> stack = new Stack<>();

            stack.push("John");
            stack.push("Charan");
            stack.push("Naidu");
            stack.push("Ramesh");

            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.peek());

            // Expression  = (a + b + c)

    }
}
