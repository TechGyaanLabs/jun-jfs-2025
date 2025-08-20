package com.careerit.jfs.cj.day29;

import org.apache.commons.text.StringSubstitutor;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WorkingWithProperties {

    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            InputStream in =
                    WorkingWithProperties.class
                            .getClassLoader()
                            .getResourceAsStream("application.properties");
            properties.load(in);

            String name = properties.getProperty("app_name");
            String version = properties.getProperty("app_version");
            String email = properties.getProperty("help_email");



            Map<String, String> propertiesMap =  new HashMap<>();
            for(String key : properties.stringPropertyNames()){
                propertiesMap.put(key, properties.getProperty(key));
            }
            StringSubstitutor sub = new StringSubstitutor(propertiesMap,"{{","}}");
            String message = sub.replace(properties.getProperty("app_bootstrap_message"));
            System.out.println("Name: " + name);
            System.out.println("Version: " + version);
            System.out.println("Email: " + email);
            System.out.println("Message: " + message);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
