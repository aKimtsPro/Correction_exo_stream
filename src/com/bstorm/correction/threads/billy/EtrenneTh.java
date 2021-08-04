package com.bstorm.correction.threads.billy;

public class EtrenneTh extends Thread {

    private final int money;
    private final long timing;
    private final Tirelire addTo;

    public EtrenneTh(int money, long timing, Tirelire addTo) {
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

    @Override
    public String toString() {
        return "Etrenne{" +
                "money=" + money +
                ", timing=" + timing +
                ", thread=" + getName() +
                '}';
    }
}
