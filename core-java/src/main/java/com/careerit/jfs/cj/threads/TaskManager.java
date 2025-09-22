package com.careerit.jfs.cj.threads;

public final class TaskManager {

    private static  volatile TaskManager instance;

    private TaskManager() {
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }
}
