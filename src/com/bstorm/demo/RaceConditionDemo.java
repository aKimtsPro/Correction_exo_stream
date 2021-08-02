package com.bstorm.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo {

    public static int compteur = 0;
    private static final Object lock = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                decrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(compteur);

    }

    public static void increment(){
        synchronized (lock) {
            try {
                lock.wait();
                compteur++;
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void decrement(){
        synchronized (lock) {
            try {
                lock.wait();
                compteur--;
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
