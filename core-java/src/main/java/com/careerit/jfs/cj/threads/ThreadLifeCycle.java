package com.careerit.jfs.cj.threads;

public class ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    for(int i = 0; i < 10; i++){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            System.out.println(t1.getState());
            t1.start();
            System.out.println(t1.getState());

            Thread.sleep(100);
            System.out.println(t1.getState());
            t1.join();
            System.out.println(t1.getState());

            // NEW -> Thread Created
            // RUNNABLE -> Ready to RUN
            // RUNNING -> Actively executing
            // WAITING -> Waiting indefinitely
            // TIMED_WAITING -> Waiting  with the time limit
            // TERMINATED -> Finished execution.


    }
}
