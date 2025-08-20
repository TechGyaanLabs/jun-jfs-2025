package com.careerit.jfs.cj.reflection;

import java.lang.reflect.Constructor;

public class Manager {

    public static void main(String[] args) {

        try {
            Constructor<Invoice> constructor = Invoice.class.getConstructor(String.class, String.class, double.class);
            Invoice invoice = constructor.newInstance("ABC20250801", "ABC", 100);
            invoice.showDetails();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch(InstantiationException e){
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
