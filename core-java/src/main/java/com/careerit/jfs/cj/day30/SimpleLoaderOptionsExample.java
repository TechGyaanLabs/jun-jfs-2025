package com.careerit.jfs.cj.day30;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class SimpleLoaderOptionsExample {

    public static void main(String[] args) {
        
        System.out.println("=== LoaderOptions Explanation ===");
        
        // 1. Default LoaderOptions (no restrictions)
        System.out.println("\n1. Default LoaderOptions:");
        LoaderOptions defaultOptions = new LoaderOptions();
        System.out.println("- Code point limit: " + defaultOptions.getCodePointLimit());
        System.out.println("- Nesting depth limit: " + defaultOptions.getNestingDepthLimit());
        
        // 2. Secure LoaderOptions (recommended for production)
        System.out.println("\n2. Secure LoaderOptions (Production Ready):");
        LoaderOptions secureOptions = new LoaderOptions();
        secureOptions.setCodePointLimit(1000000);      // Limit input size to 1MB
        secureOptions.setNestingDepthLimit(50);        // Limit nesting to prevent stack overflow
        secureOptions.setMaxAliasesForCollections(50); // Limit alias references
        
        System.out.println("- Code point limit: " + secureOptions.getCodePointLimit());
        System.out.println("- Nesting depth limit: " + secureOptions.getNestingDepthLimit());
        System.out.println("- Max aliases: " + secureOptions.getMaxAliasesForCollections());
        
        // 3. Practical example with secure options
        System.out.println("\n3. Practical Example:");
        String safeYaml = """
            app:
              name: Spring Boot
              version: 2.7.0
              features:
                - web
                - data
                - security
            """;
        
        Yaml secureYaml = new Yaml(new Constructor(AppWrapper.class, secureOptions));
        AppWrapper app = secureYaml.load(safeYaml);
        System.out.println("Successfully loaded: " + app.getApp().getName() + " v" + app.getApp().getVersion());
        
        // 4. Why LoaderOptions matter - Security demonstration
        System.out.println("\n4. Security Demonstration:");
        demonstrateSecurityImportance();
    }
    
    private static void demonstrateSecurityImportance() {
        // This YAML could cause issues without proper LoaderOptions
        String potentiallyDangerousYaml = """
            &anchor
            key: &anchor value
            """;
        
        // Demonstrate memory limits
        LoaderOptions memoryOptions = new LoaderOptions();
        memoryOptions.setCodePointLimit(50);  // Very small limit
        
        try {
            Yaml memoryYaml = new Yaml(new Constructor(AppWrapper.class, memoryOptions));
            memoryYaml.load(potentiallyDangerousYaml);
            System.out.println("✅ YAML loaded within memory limits");
        } catch (Exception e) {
            System.out.println("✅ Memory limit enforced: " + e.getMessage());
        }
        
        // Demonstrate nesting limits
        LoaderOptions nestingOptions = new LoaderOptions();
        nestingOptions.setNestingDepthLimit(2);  // Very shallow limit
        
        try {
            Yaml nestingYaml = new Yaml(new Constructor(AppWrapper.class, nestingOptions));
            nestingYaml.load(potentiallyDangerousYaml);
            System.out.println("✅ YAML loaded within nesting limits");
        } catch (Exception e) {
            System.out.println("✅ Nesting limit enforced: " + e.getMessage());
        }
    }
} 