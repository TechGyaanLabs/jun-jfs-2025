package com.careerit.jfs.cj.day29;

import org.apache.commons.text.StringSubstitutor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkingPropertiesExample {

    public static void main(String[] args) {

        InputStream in =
                WorkingPropertiesExample.class
                        .getClassLoader()
                        .getResourceAsStream("application.properties");

        Properties properties = new Properties();

        try {
            properties.load(in);
            Map<String,Object> map = convertPropertiesToMap(properties);
            List<String> names = List.of("Krish","Manoj","Charan");
            StringSubstitutor sb = new StringSubstitutor(map,"{{","}}");
            for(String name : names){
                map.put("name",name);
                String message = properties.getProperty("message");
                // Get all the token which enclosed by {{ and }}
                List<String> tokens = extractTokens(message);
                System.out.println(tokens);
                System.out.println(sb.replace(message));
                System.out.println("-".repeat(100));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Map<String, Object> convertPropertiesToMap(Properties properties) {
        Map<String, Object> map = new java.util.HashMap<>();
        for(String key : properties.stringPropertyNames()){
            map.put(key, properties.getProperty(key));
        }
        return map;
    }

    public static List<String> extractTokens(String message) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{\\{(\\w+)\\}\\}");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            tokens.add(matcher.group(1)); // group(1) captures the token inside {{ }}
        }
        return tokens;
    }

}
