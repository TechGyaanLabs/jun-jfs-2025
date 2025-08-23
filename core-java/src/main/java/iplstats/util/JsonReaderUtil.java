package iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iplstats.domain.Player;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class JsonReaderUtil {

    private JsonReaderUtil() {}


    public static List<Player> getPlayers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = JsonReaderUtil.class
                    .getClassLoader().getResourceAsStream("players.json");
            return mapper.readValue(inputStream, new TypeReference<List<Player>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
