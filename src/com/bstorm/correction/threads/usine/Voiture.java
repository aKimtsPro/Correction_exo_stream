package com.bstorm.correction.threads.usine;

public class Voiture {

    private Moteur moteur;
    private Carcasse carcasse;
    private Carosserie carosserie;

    public Voiture(Moteur moteur, Carcasse carcasse, Carosserie carosserie) {
        this.moteur = moteur;
        this.carcasse = carcasse;
        this.carosserie = carosserie;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public Carcasse getCarcasse() {
        return carcasse;
    }

    public void setCarcasse(Carcasse carcasse) {
        this.carcasse = carcasse;
    }

    public Carosserie getCarosserie() {
        return carosserie;
    }

    public void setCarosserie(Carosserie carosserie) {
        this.carosserie = carosserie;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "moteur=" + moteur +
                ", carcasse=" + carcasse +
                ", carosserie=" + carosserie +
                '}';
    }
}
