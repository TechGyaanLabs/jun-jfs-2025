package com.careerit.jfs.cj.day25;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListExample2 {

    public static void main(String[] args) {

            String data = """
                    {
                        "pid":1001,
                        "name":"iPhone 16 Pro Max",
                        "price":150000
                    }
                    """;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(data, Product.class);
            System.out.println(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
