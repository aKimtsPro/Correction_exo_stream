package com.bstorm.demo.procon;

public class Main {

    public static void main(String[] args) {

        NumberStock ns = new NumberStock();

        Consommateur c1 = new Consommateur(ns,"1",1000);
        Consommateur c2 = new Consommateur(ns,"2",1000);
        Consommateur c3 = new Consommateur(ns,"3",1000);
//        Producteur p1 = new Producteur(ns, "1", 2000);
//        Producteur p2 = new Producteur(ns, "2", 1000);
        Producteur p3 = new Producteur(ns, "3", 200);

//        p1.start();
//        p2.start();
        p3.start();
        c1.start();
//        c2.start();
//        c3.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        p1.interrupt();
//        p2.interrupt();
        p3.interrupt();
        c1.interrupt();
//        c2.interrupt();
//        c3.interrupt();

    }
}
