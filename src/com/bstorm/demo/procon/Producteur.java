package com.bstorm.demo.procon;

public class Producteur extends Thread {

    private final NumberStock produceFor;
    private final long timing;

    private static int count = 0;
    private static final Object lock = new Object();

    public Producteur(NumberStock produceFor, String name, long timing) {
        super("PROD-"+name);
        this.produceFor = produceFor;
        this.timing = timing;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                Thread.sleep(timing);
            } catch (InterruptedException e) {
                return;
            }
            synchronized (lock){
                produceFor.add(count++);
                System.out.println(Thread.currentThread().getName() + " a ajouté " + (count-1));
            }
        }
    }
}
