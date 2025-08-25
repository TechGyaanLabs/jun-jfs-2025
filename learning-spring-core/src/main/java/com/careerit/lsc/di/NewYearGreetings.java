package com.careerit.lsc.di;

public class NewYearGreetings implements GreetingService {
    @Override
    public String greeting(String name) {
        return "Dear " + name + ", Happy New Year";
    }
}
