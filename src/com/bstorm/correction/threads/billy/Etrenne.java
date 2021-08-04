package com.bstorm.correction.threads.billy;

public class Etrenne implements Runnable{

    private final int money;
    private final long timing;
    private final Tirelire addTo;
    private final Thread thread = new Thread(this);

    public Etrenne(int money, long timing, Tirelire addTo) {
        this.money = money;
        this.timing = timing;
        this.addTo = addTo;
    }

    public int getMoney() {
        return money;
    }

    public long getTiming() {
        return timing;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            addTo.addMoney(money);
            try {
                Thread.sleep(timing);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void start(){
        thread.start();
    }

    public void interrupt(){
        thread.interrupt();
    }

    public long getId(){
        return thread.getId();
    }

    @Override
    public String toString() {
        return "Etrenne{" +
                "money=" + money +
                ", timing=" + timing +
                ", thread=" + thread.getName() + " ~ id : " + thread.getId() +
                '}';
    }
}
