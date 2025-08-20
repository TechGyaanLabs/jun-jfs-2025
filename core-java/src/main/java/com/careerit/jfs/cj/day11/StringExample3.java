package com.careerit.jfs.cj.day11;

import org.apache.commons.text.StringSubstitutor;

import java.util.List;
import java.util.Map;

public class StringExample3 {

    public static void main(String[] args) {

        List<Map<String,Object>> invoiceMap  = List.of(
                Map.of("customerName","Krish","invoiceNumber",1001,"invoiceDate","2023-06-01","totalAmount",45000.0,"email","Krish@.com"),
                Map.of("customerName","Manoj","invoiceNumber",1002,"invoiceDate","2023-06-02","totalAmount",50000.0,"email","Manoj@.com"),
                Map.of("customerName","Praveen","invoiceNumber",1003,"invoiceDate","2023-06-03","totalAmount",55000.0,"email","Praveen@.com")

        );

        String message = "Hi <<customerName>>, \n\tyour invoice number is <<invoiceNumber>> and your invoice date is <<invoiceDate>> and your total amount is <<totalAmount>> and your email is <<email>>";

        for(Map<String,Object> map : invoiceMap) {
            StringSubstitutor sub = new StringSubstitutor(map,"<<",">>");
            String finalMessage = sub.replace(message);
            System.out.println(finalMessage);
            System.out.println("----------------------------------");
        }
    }
}
