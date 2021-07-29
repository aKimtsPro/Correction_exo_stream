package com.bstorm.correction.threads.exo1;

public class Main {
    public static void main(String[] args) {



        Thread t1sec = new Thread( ticTac(1, 20) );
        Thread t5sec = new Thread( ticTac(5, 20) );

        t1sec.start();
        t5sec.start();

    }

    public static Runnable ticTac(long nbrSecEntre, long nbrSecTotal){
        return () -> {
            int nbrSecondePassee = 0;
            while(nbrSecondePassee < nbrSecTotal){
                try{
                    Thread.sleep( nbrSecEntre * 1000);
                    System.out.println(nbrSecEntre +" seconde(s) est/sont passée(s).");
                    nbrSecondePassee += nbrSecEntre;
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
    }
}
