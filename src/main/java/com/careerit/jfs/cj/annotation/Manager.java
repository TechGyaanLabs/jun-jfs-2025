package com.careerit.jfs.cj.annotation;

import java.lang.annotation.Annotation;

public class Manager {

    public static void main(String[] args) {
         Book book = new Book();

        Annotation[] annotations = book.getClass().getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation instanceof Author author){
                System.out.println(author.name());
                System.out.println(author.date());
            }
        }
    }
}
