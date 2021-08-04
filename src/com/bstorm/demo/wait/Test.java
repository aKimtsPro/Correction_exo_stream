package com.bstorm.demo.wait;

public class Test {


    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " - est entrée dans m1");
        try {
            System.out.println(Thread.currentThread().getName() + " - enters in waiting");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - sort de m1");
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName() + " - est entrée dans m2");
        try {
            Thread.sleep(3000);
//            notify();
            notifyAll();
            System.out.println("after 3s, " + Thread.currentThread().getName() + " notifies");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - sort de m2");
    }
}
