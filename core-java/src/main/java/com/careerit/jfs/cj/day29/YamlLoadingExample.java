package com.careerit.jfs.cj.day29;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlLoadingExample {

    public static void main(String[] args) {
        
        System.out.println("=== YAML Loading with Prefixes Example ===");
        
        // 1. Load Tenant details from YAML
        System.out.println("\n1. Loading Tenant Details:");
        Tenant tenant = TenantPropertiesManager.loadTenantDetailsFromYaml();
        if (tenant != null) {
            System.out.println("Tenant Name: " + tenant.getName());
            System.out.println("Tenant IP: " + tenant.getIp());
            System.out.println("Tenant Emails: " + tenant.getEmails());
            System.out.println("Tenant States: " + tenant.getStates());
        }
        
        // 2. Load Database details from YAML
        System.out.println("\n2. Loading Database Details:");
        DatabaseProperties db = TenantPropertiesManager.loadDatabaseDetailsFromYaml();
        if (db != null) {
            System.out.println("Database URL: " + db.getUrl());
            System.out.println("Database Username: " + db.getUsername());
            System.out.println("Database Password: " + db.getPassword());
        }
        
        // 3. Demonstrate direct YAML loading with wrapper
        System.out.println("\n3. Direct YAML Loading with Wrapper:");
        demonstrateDirectYamlLoading();
    }
    
    private static void demonstrateDirectYamlLoading() {
        try {
            // Load the entire YAML file with both tenant and db sections
            var in = YamlLoadingExample.class.getClassLoader()
                    .getResourceAsStream("tenant.yaml");
            
            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(TenantYamlWrapper.class, loaderOptions));
            
            TenantYamlWrapper wrapper = yaml.load(in);
            
            System.out.println("=== Complete YAML Structure ===");
            System.out.println("Tenant: " + wrapper.getTenant());
            System.out.println("Database: " + wrapper.getDb());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 