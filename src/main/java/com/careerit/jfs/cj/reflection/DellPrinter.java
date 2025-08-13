package com.careerit.jfs.cj.reflection;

public class DellPrinter implements Printer {
    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName()+ " is printing");
    }
}
