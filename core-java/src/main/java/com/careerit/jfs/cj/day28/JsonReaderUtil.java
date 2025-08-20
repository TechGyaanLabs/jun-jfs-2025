package com.careerit.jfs.cj.day28;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonReaderUtil {


    public static <T> List<T> loadJson(InputStream inputStream, TypeReference<List<T>> typeReference) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, typeReference);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T loadJson(InputStream inputStream, Class<T> clazz) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, clazz);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
