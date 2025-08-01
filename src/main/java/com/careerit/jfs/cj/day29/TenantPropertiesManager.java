package com.careerit.jfs.cj.day29;


import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

public class TenantPropertiesManager {

    public static void main(String[] args) {

        try {
            InputStream in =
                    TenantPropertiesManager.class
                            .getClassLoader()
                            .getResourceAsStream("tenant.yaml");

            Properties properties = new Properties();
            properties.load(in);
            String name = properties.getProperty("tenant.name");
            String ip = properties.getProperty("tenant.ip");

            tenant.getEmails().forEach(email -> System.out.println("Email: " + email));



            Tenant tenant = new Tenant();
            tenant.setName(name);
            tenant.setIp(ip);
            tenant.setEmail(Stream.of(emails).toList());
            System.out.println(tenant);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Tenant loadTenantDetailsFromProperties() {
        try {
            InputStream in = TenantPropertiesManager.class
                    .getClassLoader()
                    .getResourceAsStream("tenant.yaml");

            Properties properties = new Properties();
            properties.load(in);

            String name = properties.getProperty("tenant.name");
            String ip = properties.getProperty("tenant.ip");
            String emails = properties.getProperty("tenant.emails");

            String[] emailArray = emails.split(",");

            Tenant tenant = new Tenant();
            tenant.setName(name);
            tenant.setIp(ip);
            tenant.setEmail(Collections.singletonList(Stream.of(emailArray).map(String::trim).toList()));

            return tenant;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Tenant loadTenantDetailsFromYaml() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/tenants.yaml");
            Yaml yaml = new Yaml(); 
            Map<String, Object> data = yaml.load(inputStream);

            System.out.println("YAML Data:");
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }}
