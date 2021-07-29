package com.bstorm.demo;

import java.util.Scanner;

public class InterruptDemo {

    static long l = 0;

    public static void main(String[] args) {

        Thread t = new Thread( ticTac(1, Integer.MAX_VALUE) );
        Thread t2 = new Thread( ()  -> {
            while(!Thread.interrupted())
                increment();

            System.out.println(l);
        });

        t.start();
        t2.start();

        System.out.println("Appuyez sur 'entrer' pour stopper le tic-tac et comptage");
        new Scanner(System.in).nextLine();

        t.interrupt();
        t2.interrupt();

    }

    public static Runnable ticTac(long nbrSecEntre, long nbrSecTotal) {
        return () -> {
            int nbrSecondePassee = 0;
            while( !Thread.interrupted() && nbrSecondePassee < nbrSecTotal){
                try{
                    System.out.println(Thread.interrupted());
                    Thread.sleep( nbrSecEntre * 1000);
                    System.out.println(nbrSecEntre +" seconde(s) est/sont passée(s).");
                    nbrSecondePassee += nbrSecEntre;
                }
                catch (InterruptedException e){
                    return;
                }
            }
        };
    }

    public static void increment(){
        l++;
    }



}
