package com.careerit.jfs.cj.day29;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TenantPropertiesManager {

    public static void main(String[] args) {

        try {

            // Test the new method
            System.out.println("\n=== Loading from Properties ===");
            Tenant tenantFromProps = loadTenantDetailsFromProperties();
            System.out.println(tenantFromProps);

            Tenant tenantFromYaml = loadTenantDetailsFromYaml();
            System.out.println("\n=== Loading Tenant from YAML ===");
            System.out.println(tenantFromYaml);
            
            DatabaseProperties dbFromYaml = loadDatabaseDetailsFromYaml();
            System.out.println("\n=== Loading Database from YAML ===");
            System.out.println(dbFromYaml);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Tenant loadTenantDetailsFromProperties() {
        try {
            InputStream in = TenantPropertiesManager.class
                    .getClassLoader()
                    .getResourceAsStream("tenent.properties");

            Properties properties = new Properties();
            properties.load(in);
            
            // Load basic tenant properties
            String name = properties.getProperty("tenant.name");
            String ip = properties.getProperty("tenant.ip");
            
            // Load emails
            List<String> emails = new ArrayList<>();
            int emailIndex = 0;
            while (properties.getProperty("tenant.emails[" + emailIndex + "]") != null) {
                emails.add(properties.getProperty("tenant.emails[" + emailIndex + "]"));
                emailIndex++;
            }
            
            // Load states and cities
            List<State> states = new ArrayList<>();
            int stateIndex = 0;
            while (properties.getProperty("tenant.locations.state[" + stateIndex + "].name") != null) {
                State state = new State();
                state.setName(properties.getProperty("tenant.locations.state[" + stateIndex + "].name"));
                
                List<String> cities = new ArrayList<>();
                int cityIndex = 0;
                while (properties.getProperty("tenant.locations.state[" + stateIndex + "].cities[" + cityIndex + "]") != null) {
                    cities.add(properties.getProperty("tenant.locations.state[" + stateIndex + "].cities[" + cityIndex + "]"));
                    cityIndex++;
                }
                state.setCities(cities);
                states.add(state);
                stateIndex++;
            }
            
            // Create and populate tenant object
            Tenant tenant = new Tenant();
            tenant.setName(name);
            tenant.setIp(ip);
            tenant.setEmails(emails);
            tenant.setStates(states);
            
            return tenant;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Tenant loadTenantDetailsFromYaml() {
        try {
            InputStream in = TenantPropertiesManager.class
                    .getClassLoader()
                    .getResourceAsStream("tenant.yaml");

            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(TenantYamlWrapper.class, loaderOptions));
            
            TenantYamlWrapper wrapper = yaml.load(in);
            return wrapper.getTenant();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static DatabaseProperties loadDatabaseDetailsFromYaml() {
        try {
            InputStream in = TenantPropertiesManager.class
                    .getClassLoader()
                    .getResourceAsStream("tenant.yaml");

            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(TenantYamlWrapper.class, loaderOptions));
            
            TenantYamlWrapper wrapper = yaml.load(in);
            return wrapper.getDb();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
