package com.bstorm.correction.streams.service;

public class Produit {

    private final String nom;
    private final double prix;
    private final String brand;
    private final Type type;
    private int stock;

    public Produit(String nom, double prix, String brand, Type type, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.brand = brand;
        this.type = type;
        this.stock = stock;
    }

    void addToStock(int toAdd){
        if(toAdd < 0)
            throw new IllegalArgumentException("should be positive");

        stock += toAdd;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getBrand() {
        return brand;
    }

    public Type getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public enum Type {
        COMESTIBLE,
        PETIT,
        GROS
    }

    @Override
    public String toString() {
        return " --- " + nom + " --- " +
                "\n\t prix= " + prix +
                "\n\t brand= " + brand  +
                "\n\t type= " + type +
                "\n\t stock= " + stock ;
    }
}
