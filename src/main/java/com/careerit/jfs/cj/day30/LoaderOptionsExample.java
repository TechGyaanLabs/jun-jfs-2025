package com.careerit.jfs.cj.day30;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class LoaderOptionsExample {

    public static void main(String[] args) {
        
        // 1. Basic LoaderOptions with default settings
        System.out.println("=== Basic LoaderOptions ===");
        LoaderOptions basicOptions = new LoaderOptions();
        Yaml basicYaml = new Yaml(new Constructor(AppWrapper.class, basicOptions));
        
        // 2. LoaderOptions with custom settings
        System.out.println("\n=== Custom LoaderOptions ===");
        LoaderOptions customOptions = new LoaderOptions();
        
        // Security settings
        customOptions.setAllowRecursiveKeys(false);  // Prevent recursive key definitions
        customOptions.setAllowDuplicateKeys(false);  // Prevent duplicate keys
        customOptions.setMaxAliasesForCollections(50);  // Limit alias references
        
        // Memory and performance settings
        customOptions.setCodePointLimit(1000000);  // Limit input size (1MB)
        customOptions.setNestingDepthLimit(50);    // Limit nesting depth
        
        // Tag settings
        customOptions.setProcessComments(true);  // Process comments in YAML
        
        Yaml customYaml = new Yaml(new Constructor(AppWrapper.class, customOptions));
        
        // 3. Demonstrate different scenarios
        demonstrateSecuritySettings();
        demonstrateMemorySettings();
        demonstrateNestingSettings();
    }
    
    private static void demonstrateSecuritySettings() {
        System.out.println("\n=== Security Settings Demo ===");
        
        // Example with recursive keys (potentially dangerous)
        String recursiveYaml = """
            &anchor
            key: &anchor value
            """;
        
        LoaderOptions secureOptions = new LoaderOptions();
        secureOptions.setAllowRecursiveKeys(false);
        
        try {
            Yaml secureYaml = new Yaml(new Constructor(AppWrapper.class, secureOptions));
            secureYaml.load(recursiveYaml);
            System.out.println("Recursive keys are disabled - this should fail");
        } catch (Exception e) {
            System.out.println("Security check passed: " + e.getMessage());
        }
    }
    
    private static void demonstrateMemorySettings() {
        System.out.println("\n=== Memory Settings Demo ===");
        
        LoaderOptions memoryOptions = new LoaderOptions();
        memoryOptions.setCodePointLimit(100);  // Very small limit for demo
        
        String largeYaml = """
            app:
              name: "This is a very long string that exceeds the code point limit"
              version: 1.0
            """;
        
        try {
            Yaml memoryYaml = new Yaml(new Constructor(AppWrapper.class, memoryOptions));
            memoryYaml.load(largeYaml);
            System.out.println("Memory limit check passed");
        } catch (Exception e) {
            System.out.println("Memory limit exceeded: " + e.getMessage());
        }
    }
    
    private static void demonstrateNestingSettings() {
        System.out.println("\n=== Nesting Settings Demo ===");
        
        LoaderOptions nestingOptions = new LoaderOptions();
        nestingOptions.setNestingDepthLimit(3);  // Limit nesting to 3 levels
        
        String deeplyNestedYaml = """
            level1:
              level2:
                level3:
                  level4:
                    level5:
                      value: "too deep"
            """;
        
        try {
            Yaml nestingYaml = new Yaml(new Constructor(AppWrapper.class, nestingOptions));
            nestingYaml.load(deeplyNestedYaml);
            System.out.println("Nesting depth check passed");
        } catch (Exception e) {
            System.out.println("Nesting depth exceeded: " + e.getMessage());
        }
    }
} 