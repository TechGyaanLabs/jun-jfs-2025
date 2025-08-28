package com.careerit.lsc.di.dp.singleton;

public class Singleton {


    private Singleton(){
        System.out.println("Singleton instance created");
    }

    public static Singleton getInstance(){
        return Holder.instance;
    }

    static class  Holder{
           private final static Singleton instance = new Singleton();
    }

}