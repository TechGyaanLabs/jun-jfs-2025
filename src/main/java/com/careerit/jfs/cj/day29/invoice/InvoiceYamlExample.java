package com.careerit.jfs.cj.day29.invoice;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class InvoiceYamlExample {

    public static void main(String[] args) {
        
        System.out.println("=== Invoice YAML Loading Example ===");
        
        try {
            // Load the invoice YAML file
            InputStream in = InvoiceYamlExample.class.getClassLoader()
                    .getResourceAsStream("invoice.yaml");
            
            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(InvoiceYamlWrapper.class, loaderOptions));
            
            InvoiceYamlWrapper wrapper = yaml.load(in);
            
            // Display invoice details
            displayInvoiceDetails(wrapper);
            
            // Display customer information
            displayCustomerInfo(wrapper);
            
            // Display items
            displayItems(wrapper);
            
            // Display payment terms
            displayPaymentTerms(wrapper);
            
            // Calculate and display totals
            calculateAndDisplayTotals(wrapper);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void displayInvoiceDetails(InvoiceYamlWrapper wrapper) {
        System.out.println("\n=== INVOICE DETAILS ===");
        Invoice invoice = wrapper.getInvoice();
        System.out.println("Invoice Number: " + invoice.getInvoice_number());
        System.out.println("Date: " + invoice.getDate());
        System.out.println("Due Date: " + invoice.getDue_date());
        System.out.println("Status: " + invoice.getStatus());
        System.out.println("Currency: " + invoice.getCurrency());
        System.out.println("Notes: " + invoice.getNotes());
    }
    
    private static void displayCustomerInfo(InvoiceYamlWrapper wrapper) {
        System.out.println("\n=== CUSTOMER INFORMATION ===");
        Customer customer = wrapper.getCustomer();
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Address: " + customer.getAddress());
        
        System.out.println("\n=== BILLER INFORMATION ===");
        Biller biller = wrapper.getBiller();
        System.out.println("Company: " + biller.getCompany_name());
        System.out.println("Email: " + biller.getEmail());
        System.out.println("Phone: " + biller.getPhone());
        System.out.println("Address: " + biller.getAddress());
    }
    
    private static void displayItems(InvoiceYamlWrapper wrapper) {
        System.out.println("\n=== INVOICE ITEMS ===");
        System.out.printf("%-8s %-25s %-15s %-10s %-12s %-10s%n", 
                "ID", "Name", "Category", "Quantity", "Unit Price", "Total");
        System.out.println("=".repeat(80));
        
        for (InvoiceItem item : wrapper.getItems()) {
            System.out.printf("%-8s %-25s %-15s %-10d $%-11.2f $%-9.2f%n",
                    item.getId(),
                    item.getName().substring(0, Math.min(24, item.getName().length())),
                    item.getCategory(),
                    item.getQuantity(),
                    item.getUnit_price(),
                    item.getTotal());
        }
    }
    
    private static void displayPaymentTerms(InvoiceYamlWrapper wrapper) {
        System.out.println("\n=== PAYMENT TERMS ===");
        PaymentTerms terms = wrapper.getPayment_terms();
        System.out.println("Net Days: " + terms.getNet_days());
        System.out.println("Late Fee Rate: " + (terms.getLate_fee_rate() * 100) + "%");
        System.out.println("Grace Period: " + terms.getGrace_period_days() + " days");
        
        System.out.println("\n=== SHIPPING INFORMATION ===");
        Shipping shipping = wrapper.getShipping();
        System.out.println("Method: " + shipping.getMethod());
        System.out.println("Cost: $" + shipping.getCost());
        System.out.println("Tracking: " + shipping.getTracking_number());
        System.out.println("Estimated Delivery: " + shipping.getEstimated_delivery());
    }
    
    private static void calculateAndDisplayTotals(InvoiceYamlWrapper wrapper) {
        System.out.println("\n=== FINANCIAL SUMMARY ===");
        Invoice invoice = wrapper.getInvoice();
        
        System.out.printf("Subtotal: $%.2f%n", invoice.getSubtotal());
        System.out.printf("Tax Rate: %.1f%%%n", invoice.getTax_rate() * 100);
        System.out.printf("Tax Amount: $%.2f%n", invoice.getTax_amount());
        System.out.printf("Discount Rate: %.1f%%%n", invoice.getDiscount_rate() * 100);
        System.out.printf("Discount Amount: $%.2f%n", invoice.getDiscount_amount());
        System.out.println("=".repeat(30));
        System.out.printf("TOTAL AMOUNT: $%.2f%n", invoice.getTotal_amount());
        
        // Verify calculations
        double calculatedTotal = invoice.getSubtotal() + invoice.getTax_amount() - invoice.getDiscount_amount();
        System.out.printf("Calculated Total: $%.2f%n", calculatedTotal);
        System.out.println("Calculation Match: " + (Math.abs(calculatedTotal - invoice.getTotal_amount()) < 0.01));
    }
} 