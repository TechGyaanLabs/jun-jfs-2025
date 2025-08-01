package com.careerit.jfs.cj.day29;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

public class ReadYamlConvertPojo {

    public static void main(String[] args) {

        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(Map.class, loaderOptions));
        InputStream in = TenantPropertiesManager.class
                .getClassLoader()
                .getResourceAsStream("application.yaml");

        Map<String, Object> yamlProperties = yaml.load(in);
        System.out.println(yamlProperties);

        // Convert  map to Tenant Object
        // Convert map to DatabaseProperties Object

        Map<String, Object> tenantMap = (Map<String, Object>) yamlProperties.get("tenant");
        Tenant tenant = new Tenant();

        ObjectMapper mapper = new ObjectMapper();
        tenant = mapper.convertValue(tenantMap, Tenant.class);
        System.out.println(tenant);

        Map<String, Object> dbMap = (Map<String, Object>) yamlProperties.get("db");
        DatabaseProperties db = new DatabaseProperties();
        db = mapper.convertValue(dbMap, DatabaseProperties.class);
        System.out.println(db);

        Map<String, Object> mailDataMap = (Map<String, Object>) yamlProperties.get("mail");
        MailConfig obj = mapper.convertValue(mailDataMap, MailConfig.class);
        System.out.println(obj);

    }
}
