package com.careerit.jfs.cj.reflection;

public class PrinterManager {

    public static void main(String[] args) {

            Printer printer = PrinterFactory.getPrinter();
            printer.print();
    }
}
