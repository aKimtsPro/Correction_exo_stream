package com.bstorm.correction.threads.theatre;

import java.util.LinkedList;

public class Script {

    private final LinkedList<String> lignes = new LinkedList<>();

    public synchronized void addLigne(String toAdd){
        if( isFull() ){
            System.out.println("PAUSE POUR : " + Thread.currentThread().getName());
            while( isFull() ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("PLAY POUR : " + Thread.currentThread().getName());
        }
        lignes.addLast(toAdd);
        notifyAll();
    }

    public synchronized String getFirstLigne(){
        if(isEmpty()){
            System.out.println("PAUSE POUR : " + Thread.currentThread().getName());
            while( isEmpty() ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            System.out.println("PLAY POUR : " + Thread.currentThread().getName());
        }
        String ligne = lignes.getFirst();
        lignes.removeFirst();
        notifyAll();
        return ligne;
    }

    public boolean isFull(){
        return lignes.size() >= 10;
    }

    public boolean isEmpty(){
        return lignes.size() == 0;
    }
}
