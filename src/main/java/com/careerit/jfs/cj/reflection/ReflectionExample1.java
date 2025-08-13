package com.careerit.jfs.cj.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionExample1 {

    public static void main(String[] args) {

        try{
            Class c = Class.forName("java.lang.Integer");
            Method[] methods = c.getMethods();
            for(Method method : methods) {
                System.out.println(method);
            }

            Constructor[] constructors = c.getDeclaredConstructors();
            for(Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            Class superclass = c.getSuperclass();
            System.out.println(superclass);
            Class[] interfaces = c.getInterfaces();
            for(Class anInterface : interfaces) {
                System.out.println(anInterface);
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
