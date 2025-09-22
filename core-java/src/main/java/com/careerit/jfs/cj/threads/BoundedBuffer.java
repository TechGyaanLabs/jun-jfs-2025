package com.careerit.jfs.cj.threads;

import java.util.ArrayDeque;
import java.util.Queue;

class BoundedBuffer<E> {
    private final Queue<E> q = new ArrayDeque<>();
    private final int capacity;
    private final Object lock = new Object();

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void put(E e) throws InterruptedException {
        synchronized (lock) {
            while (q.size() == capacity) {
                lock.wait();
            }
            q.add(e);
            lock.notifyAll();
        }
    }

    public E take() throws InterruptedException {
        synchronized (lock) {
            while (q.isEmpty()) {
                lock.wait();
            }
            E e = q.remove();
            lock.notifyAll();
            return e;
        }
    }

    public static void main(String[] args) {

        BoundedBuffer<Integer> obj = new BoundedBuffer<Integer>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    obj.put(i);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                while(true) {
                    var res = obj.take();
                    System.out.println(res);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}