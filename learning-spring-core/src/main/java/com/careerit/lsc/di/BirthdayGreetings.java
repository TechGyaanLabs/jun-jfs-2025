package com.careerit.lsc.di;

public class BirthdayGreetings implements GreetingService{
    @Override
    public String greeting(String name) {
       return "Dear " + name + ", Happy Birthday";
    }
}
