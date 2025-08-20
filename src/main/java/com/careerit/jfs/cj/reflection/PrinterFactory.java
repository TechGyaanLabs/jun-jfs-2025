package com.careerit.jfs.cj.reflection;

import java.io.FileInputStream;
import java.util.Properties;

public class PrinterFactory {
    final static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(PrinterFactory.class.getClassLoader().getResource("printer.properties").getFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Printer getPrinter() {

        try {
            String printerClass = properties.getProperty("printer.class");
            Class c = Class.forName(printerClass);
            return (Printer) c.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
