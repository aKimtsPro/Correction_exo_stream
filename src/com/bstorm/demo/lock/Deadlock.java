package com.bstorm.demo.lock;

public class Deadlock {

    private static class Ami {

        private String nom;

        public Ami(String nom) {
            this.nom = nom;
        }

        public synchronized void saluer(Ami aSaluer){
            System.out.println(nom + " - salut " + aSaluer.getNom());
            aSaluer.repondre(this);
        }

        public synchronized void repondre(Ami aSaluer){
            System.out.println(nom + " - oh salut " + aSaluer.getNom());
        }


        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Ami a1 = new Ami("pol");
        Ami a2 = new Ami("marie");

        Thread t1 = new Thread(() -> a1.saluer(a2));
        Thread t2 = new Thread(() -> a2.saluer(a1));


        System.out.println("LANCEMENT T1");
        t1.start();
        System.out.println("LANCEMENT T2");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("FINI");

    }


}
