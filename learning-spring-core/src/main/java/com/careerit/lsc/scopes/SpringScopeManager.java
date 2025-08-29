package com.careerit.lsc.scopes;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.careerit.lsc.scopes")
public class SpringScopeManager {

    public static void main(String[] args) {

        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(SpringScopeManager.class);
        UserTaskManager userTaskManager1 = context1.getBean(UserTaskManager.class);
        userTaskManager1.show();
        context1.getBeanFactory().destroyBean(userTaskManager1);

    }

}
