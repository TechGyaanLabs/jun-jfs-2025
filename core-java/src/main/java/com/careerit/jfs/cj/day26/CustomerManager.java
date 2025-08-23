package com.careerit.jfs.cj.day26;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomerManager {

    public static void main(String[] args) {

            Address address = new Address();
            address.setCity("Bangalore");
            address.setZip("569937");

            Customer customer = new Customer();
            customer.setName("John");
            customer.setAddress(address);

            ObjectMapper objMapper = new ObjectMapper();
            objMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
            try {
                String jsonStr = objMapper.writeValueAsString(customer);
                System.out.println(jsonStr);

                Customer customer1 = objMapper.readValue(jsonStr, Customer.class);
                System.out.println(customer1);

            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
