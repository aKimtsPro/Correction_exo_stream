package com.bstorm.demo.immutable;

public class Pile {

    private int pourcentageCharge = 0;

    public void charger(){
        pourcentageCharge = 100;
    }

    public void decharger(){
        pourcentageCharge = 0;
    }

}
