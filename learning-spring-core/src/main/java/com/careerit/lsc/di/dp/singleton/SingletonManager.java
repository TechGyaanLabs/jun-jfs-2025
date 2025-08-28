package com.careerit.lsc.di.dp.singleton;

public class SingletonManager {

    public static void main(String[] args) {


        Thread t1 = new Thread(()->{
            TaskManager taskManager1 =TaskManager.getInstance();
            System.out.println(taskManager1);
        });

        Thread t2 = new Thread(()->{
            TaskManager taskManager1 =TaskManager.getInstance();
            System.out.println(taskManager1);
        });

        Thread t3 = new Thread(()->{
            TaskManager taskManager1 =TaskManager.getInstance();
            System.out.println(taskManager1);
        });

        t1.start();
        t2.start();
        t3.start();


        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());


       EnumSingleton obj1 = EnumSingleton.INSTANCE;
       EnumSingleton obj2 = EnumSingleton.INSTANCE;
       System.out.println(obj1);
       System.out.println(obj2);
    }
}
