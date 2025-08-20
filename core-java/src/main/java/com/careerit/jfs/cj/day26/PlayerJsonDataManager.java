package com.careerit.jfs.cj.day26;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class PlayerJsonDataManager {

    public static void main(String[] args) {

            try{
                // Load the cricketer.json file data to list player object

                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                mapper.registerModules(new JavaTimeModule());

                InputStream inputStream = PlayerJsonDataManager.class.getClassLoader()
                        .getResourceAsStream("cricketers.json");
                List<Player> players
                        = mapper.readValue(inputStream,new TypeReference<List<Player>>() {});
                System.out.println("Total cricketers: " + players.size());
                for (Player player : players) {
                    System.out.println(player);
                }

                String jsonStr =mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(players);
                System.out.println(jsonStr);

                // Write the list player object to cricketers_output.json file

                mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValue(new File("out_put.json"), players);
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
