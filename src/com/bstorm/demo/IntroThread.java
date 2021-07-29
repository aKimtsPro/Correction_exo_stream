package com.bstorm.demo;

public class IntroThread {

    public static void main(String[] args) {

        System.out.println("Début de "+ Thread.currentThread().getName() +" - attente de 2s");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fin de l'attente ");

        // 2 sec après le lancement afficher 'salut'
        // 3 sec après le lancement afficher 'oh salut comment ça va?'
        // 2 sec après avoir écrit 'salut', afficher 'bien'
        Thread t1 = new Thread(() -> {
            try {

                String nomDuThread = Thread.currentThread().getName();
                Thread.sleep(3000);
                System.out.println( nomDuThread +" - oh salut, comment ça va?");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Pol");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println( Thread.currentThread().getName() + " - salut");
                Thread.sleep(2000);
                System.out.println( Thread.currentThread().getName() + " - bien");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Marie");

        t1.start();
        t2.start();

        System.out.println("Lancement des threads");

    }

}
