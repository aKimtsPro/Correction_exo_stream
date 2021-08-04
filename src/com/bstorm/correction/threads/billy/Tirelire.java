package com.bstorm.correction.threads.billy;

import java.util.ArrayList;
import java.util.List;

public class Tirelire {

    private long solde = 0;
    private final List<Etrenne> etrennes = new ArrayList<>();
    private int nbrVersement = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void addMoney(int qtt){
        synchronized (lock1){
            solde += qtt;
        }
        synchronized (lock2){
            nbrVersement++;
        }
    }

    public long getSolde(){
        synchronized (lock1){
            return solde;
        }
    }

    public synchronized int getNbrVersement(){
        synchronized (lock2){
            return nbrVersement;
        }
    }

    public void startEtrenne( Etrenne etrenne ){
        etrenne.start();
        etrennes.add(etrenne);
    }

    public void showEtrenne(){
        etrennes.forEach(System.out::println);
    }

    public void interruptAll(){
        etrennes.forEach(Etrenne::interrupt);
        etrennes.clear();
    }

    public void interruptOne(long id){
        etrennes.stream()
                .filter((e) -> e.getId() == id)
                .findAny()
                .ifPresent(e ->{
                    etrennes.remove(e);
                    e.interrupt();
                });
    }

}
