package com.careerit.jfs.cj.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ExceptionExample4 {
    public static void main(String[] args) {
        System.out.println("Start of main method");

        try {
            List<String> names = getNames();
            System.out.println(names);
        }catch (IOException e){
            System.out.println("File not found " + e);
        }catch (Exception e){
            System.out.println("While reading the file " + e);
        }

        try {
            int res = divide(10, 0);
            System.out.println("Result: " + res);
        }catch (ArithmeticException e){
            System.out.println("Cannot divide by zero " + e);
        }
        System.out.println("End of main method");
    }

    public static List<String> getNames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(ExceptionExample4.class.getClassLoader().getResourceAsStream("common_names.json"), new TypeReference<List<String>>() {});
    }

    public static int divide(int a, int b){
       if(b == 0){
           throw new ArithmeticException("Cannot divide by zero");
       }
       return a / b;
    }
}
