package com.careerit.lsc.di;

public class CongratulationsGreetings implements GreetingService {
    @Override
    public String greeting(String name) {
        return "Dear " + name + ", Congratulations";
    }
}
