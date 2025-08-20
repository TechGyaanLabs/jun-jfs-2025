package com.careerit.jfs.cj.day28.cms;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public final class JsonReaderUtil {

    private JsonReaderUtil() {}

    public static List<Course> getCourses() {
        try {
            InputStream inputStream = JsonReaderUtil.class
                    .getClassLoader().getResourceAsStream("course_data.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, new TypeReference<List<Course>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
