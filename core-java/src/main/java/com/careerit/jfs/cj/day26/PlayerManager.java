package com.careerit.jfs.cj.day26;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PlayerManager {

    public static void main(String[] args) {

            String data = """
                        {
                            "name": "Sachin Tendulkar",
                            "dob": "1973-04-24",
                            "country": "India",
                            "role": "Batsman",
                            "runs": 10000,
                            "firstMatch": "1980-01-01",
                            "lastMatch": "1990-01-01"
                          }
                    """;
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            try {
                Player player = mapper.readValue(data, Player.class);
                System.out.println(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
