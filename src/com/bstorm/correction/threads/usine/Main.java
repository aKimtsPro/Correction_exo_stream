package com.bstorm.correction.threads.usine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(" - CREATION USINE - ");
        Usine u = new Usine();
        System.out.println(" - LANCEMENT CONSTRUCTION - ");
        Thread t = u.lancerConstruction(100,"bleu", 10);

        System.out.println(" - ATTENTE DE FIN DE CONSTRUCTION - ");

        System.out.println("En attendant, comment ca va?");
        new Scanner(System.in).nextLine();

        try {
            t.join();
            System.out.println(" - FIN DE CONSTRUCTION - ");
            Voiture v = u.getStockVoiture();
            if(v != null)
                System.out.println("VOITURE : " + v);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" - FIN DU PROGRAMME - ");

    }

}
