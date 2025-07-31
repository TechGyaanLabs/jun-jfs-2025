package com.careerit.jfs.cj.day29;

import java.io.InputStream;
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
            String emails = properties.getProperty("tenant.emails");

            String[] emailArray = emails.split(",");


            Tenant tenant = new Tenant();
            tenant.setName(name);
            tenant.setIp(ip);
            tenant.setEmail(Stream.of(emailArray).toList());
            System.out.println(tenant);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Tenant loadTenantDetailsFromProperties() {
        return null;
    }

    public static Tenant loadTenantDetailsFromYaml(){
        return null;
    }
}
