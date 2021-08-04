package com.bstorm.demo.immutable;

public class Telecommande {

    private final String marque;
    private final String modele;
    private final Pile pile;

    public Telecommande(String marque, String modele, Pile pile) {
        this.marque = marque;
        this.modele = modele;
        this.pile = pile;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Pile getPile() {
        return pile;
    }
}
