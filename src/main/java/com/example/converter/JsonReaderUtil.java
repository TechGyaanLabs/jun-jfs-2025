package com.example.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonReaderUtil {
    
    public static List<Player> readPlayers(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        // Load the JSON file from resources
        InputStream inputStream = JsonReaderUtil.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IOException("Could not find resource: " + filename);
        }
        
        // Read the JSON and convert to List<Player>
        List<Player> players = mapper.readValue(inputStream, new TypeReference<List<Player>>() {});
        
        inputStream.close();
        return players;
    }
} 