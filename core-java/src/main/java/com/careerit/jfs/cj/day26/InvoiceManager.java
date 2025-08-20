package com.careerit.jfs.cj.day26;

import com.careerit.jfs.cj.day26.invoice.Invoice;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;

public class InvoiceManager {

    public static void main(String[] args) {

        try{
            InputStream inputStream = InvoiceManager.class.getClassLoader()
                    .getResourceAsStream("invoice.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            mapper.registerModules(new JavaTimeModule());
            Invoice invoice = mapper.readValue(inputStream, Invoice.class);
            System.out.println(invoice);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
