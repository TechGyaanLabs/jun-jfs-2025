package com.careerit.jfs.cj.reflection;

public class SonyPrinter implements Printer {
    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName()+" is printing");
    }
}
