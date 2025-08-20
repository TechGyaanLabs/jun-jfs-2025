package com.careerit.jfs.cj.reflection;

public class HpPrinter  implements Printer {
    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + " is printing");
    }
}
