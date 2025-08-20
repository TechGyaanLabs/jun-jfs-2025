package com.careerit.jfs.cj.annotation;

import java.lang.reflect.Field;

public class GeneratingCode {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        try {
            Class c = Class.forName("com.careerit.jfs.cj.annotation.Book");

            for(Field field : c.getDeclaredFields()) {

                if(field.isAnnotationPresent(GetterSetter.class)) {
                    sb.append("public String get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1) + "() {\n");
                    sb.append("return " + field.getName() + ";\n");
                    sb.append("}\n");

                    sb.append("public void set" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1) + "(String " + field.getName() + ") {\n");
                    sb.append("this." + field.getName() + " = " + field.getName() + ";\n");
                    sb.append("}\n");
                }

            }
            System.out.println(sb);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
