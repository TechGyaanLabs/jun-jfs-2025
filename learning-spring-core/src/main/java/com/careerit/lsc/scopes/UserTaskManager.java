package com.careerit.lsc.scopes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class UserTaskManager {
    public void show(){
        System.out.println("UserTaskManager");
    }

    @PostConstruct
    public void init(){
        System.out.println("Init UserTaskManager");
    }

    @PreDestroy
    public void close(){
        System.out.println("Close UserTaskManager");
    }

}
