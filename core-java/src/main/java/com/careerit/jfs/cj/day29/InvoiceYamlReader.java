package com.careerit.jfs.cj.day29;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

public class InvoiceYamlReader {

    public static void main(String[] args) {

        // TODO read invoice from yaml file as Map

        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(Map.class, loaderOptions));
        InputStream in = TenantPropertiesManager.class
                .getClassLoader()
                .getResourceAsStream("invoice.yaml");

        Map<String, Object> invoice = yaml.load(in);
        System.out.println(invoice);

        // Invoice number, amount, and customer email

        Map<String, Object> map = (Map<String, Object>) invoice.get("invoice");
        Map<String, Object> customer = (Map<String, Object>) invoice.get("customer");

        String invoiceNumber = (String) map.get("invoice_number");
        double amount = (Double) map.get("total_amount");
        String customerEmail = (String) customer.get("email");

        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Customer Email: " + customerEmail);
    }
}
