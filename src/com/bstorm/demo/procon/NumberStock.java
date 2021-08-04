package com.bstorm.demo.procon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberStock {

    private final LinkedList<Integer> list = new LinkedList<>();

    public synchronized void add(Integer toAdd){
        if(list.size() >= 10){
            System.out.println(Thread.currentThread().getName() + " a été mis en attente - trop de nombres");
            while(list.size() >= 10){
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName() + " a été remis en marche");
        }

        list.addLast(toAdd);
        notifyAll();
    }

    public synchronized Integer getFirst(){
        if (list.size() == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " a été mis en attente - plus assez de nombres");
                while(list.size() == 0)
                    wait();
                System.out.println(Thread.currentThread().getName() + " a été relancé - un ou plusieurs éléments on été ajoutés");
            }
            catch (InterruptedException e) {
                return 0;
            }
        }

        Integer e = list.getFirst();
        list.removeFirst();
        notifyAll();
        return e;
    }


}
