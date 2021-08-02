package com.bstorm.correction.threads.usine;

public class Carosserie {

    private String couleur;

    public Carosserie(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Carosserie{" +
                "couleur='" + couleur + '\'' +
                '}';
    }
}
