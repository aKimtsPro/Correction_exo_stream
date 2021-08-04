package com.bstorm.demo.procon;

public class Consommateur extends Thread {

    private final NumberStock toConsume;
    private final long timing;

    public Consommateur(NumberStock toConsume, String name, long timing) {
        super("CONS-"+name);
        this.toConsume = toConsume;
        this.timing = timing;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            System.out.println( "------->" + Thread.currentThread().getName() + " ecrit : " + toConsume.getFirst());
            try {
                Thread.sleep(timing);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
