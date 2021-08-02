package com.bstorm.correction.threads.usine;

import java.util.Random;

public class Usine {

    private Moteur stockMoteur = null;
    private Carcasse stockCarcasse = null;
    private Carosserie stockCarosserie = null;

    private Voiture stockVoiture = null;

    public Thread lancerConstruction(int puissance, String couleur, int scoreSecurite){
        Thread t = new Thread( () -> construireVoiture(puissance, couleur, scoreSecurite) );
        t.start();
        return t;
    }

    private void construireVoiture(int puissance, String couleur, int scoreSecurite){

        Thread cMoteur = construireMoteur(puissance);
        Thread cCarosserie = construireCarosserie(couleur);
        Thread cCarcasse = construireCarcasse(scoreSecurite);

        try {
            cMoteur.join(5000);
            cCarcasse.join();
            cCarosserie.join();

            if( stockMoteur == null || stockCarosserie == null || stockCarcasse == null ){
                System.out.println("construction annulée");
                cMoteur.interrupt();
                cCarcasse.interrupt();
                cCarosserie.interrupt();
            }
            else{
                Thread.sleep(2000);
                stockVoiture = new Voiture(stockMoteur,stockCarcasse, stockCarosserie);
                System.out.println("Fin construction voiture ; " + stockVoiture);
            }

            stockMoteur = null;
            stockCarcasse = null;
            stockCarosserie = null;


        } catch (InterruptedException e) {
            cMoteur.interrupt();
            cCarcasse.interrupt();
            cCarosserie.interrupt();
            System.out.println("construction annulée");
        }

    }

    private Thread construireMoteur(int puissance){

        Thread t = new Thread(() -> {
            System.out.println("Commencement de construction moteur");
            int millisec = new Random().nextInt(4001) + 2000;
            try {
                Thread.sleep(millisec);
                stockMoteur = new Moteur(puissance);
                System.out.println("Fin de construction moteur");
            } catch (InterruptedException e) {
                System.out.println("construction moteur annulée");
            }

        });

        t.start();
        return t;

    }

    private Thread construireCarcasse(int scoreSecurite){
        Thread t = new Thread(() -> {
            System.out.println("Commencement construction carcasse");
            try {
                Thread.sleep(4000);
                stockCarcasse = new Carcasse(scoreSecurite);
                System.out.println("Fin construction carcasse");
            } catch (InterruptedException e) {
                System.out.println("construction carcasse annulée");
            }

        });

        t.start();
        return t;
    }

    private Thread construireCarosserie(String couleur){
        System.out.println("Commencement construction carosserie");
        Thread t = new Thread(() -> {

            try {
                Thread.sleep(3000);
                stockCarosserie = new Carosserie(couleur);
                System.out.println("Fin construction carosserie");
            } catch (InterruptedException e) {
                System.out.println("construction carosserie annulée");
            }

        });

        t.start();
        return t;
    }

    public Voiture getStockVoiture() {
        return stockVoiture;
    }
}
