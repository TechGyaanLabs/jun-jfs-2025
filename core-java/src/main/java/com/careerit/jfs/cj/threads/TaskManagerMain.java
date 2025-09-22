package com.careerit.jfs.cj.threads;

public class TaskManagerMain {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            TaskManager obj1 = TaskManager.getInstance();
            System.out.println(obj1);
        },"T1");

        Thread t2 = new Thread(()->{
            TaskManager obj2 = TaskManager.getInstance();
            System.out.println(obj2);
        },"T2");

        Thread t3 = new Thread(()->{
            TaskManager obj3 = TaskManager.getInstance();
            System.out.println(obj3);
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
