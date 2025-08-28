package com.careerit.lsc.di.dp.singleton;

public class TaskManager {

    private static volatile TaskManager instance;
    private TaskManager(){}

    public void showActiveTasks() {
        System.out.println("Active tasks");
    }
    public void killTask() {
        System.out.println("Task killed");
    }

    public static TaskManager getInstance() {
        if(instance == null){
            synchronized (TaskManager.class){
                if(instance == null){
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }

}
