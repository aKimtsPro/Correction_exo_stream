package com.bstorm.demo;

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup tg = new ThreadGroup("mon thread group");
        Thread t1 = new Thread(tg, () -> System.out.println("je suis t1"));
        Thread t2 = new Thread(tg, () -> System.out.println("je suis t2"));

    }
}
