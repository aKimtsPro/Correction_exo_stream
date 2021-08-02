package com.bstorm.demo;

public class JoinDemo {

    public static void main(String[] args) {

        System.out.println("Lancement du programme");

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Lancement du Thread");
                Thread.sleep(3000);
                System.out.println("3sec passées");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        System.out.println("AFFICHAGE");

        try {
            t1.join(8000);
            System.out.println("FIN DU PROGRAMME");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
