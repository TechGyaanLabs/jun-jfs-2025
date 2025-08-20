package com.careerit.jfs.cj.optinal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Manager {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("name","Virat Kohli");
        map.put("runs",15000);

        Player player = ConvertorUtil.convert(map, Player.class);
        System.out.println(player);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("pid",1001);
        map2.put("name","iPhone16 Pro Max");
        map2.put("price",150000);
        Product product = ConvertorUtil.convert(map2, Product.class);
        System.out.println(product);

       try{
           Class cls = Class.forName("java.lang.String");
           Field[] fields = cls.getDeclaredFields();
           for(Field field : fields) {
               System.out.println(field);
           }

           Method[] methods = cls.getDeclaredMethods();
           for(Method method : methods) {
               System.out.println(method);
           }

           Constructor[] constructors = cls.getDeclaredConstructors();
           for(Constructor constructor : constructors) {
               System.out.println(constructor);
           }

       } catch (ClassNotFoundException e) {
       }
    }
}
