package com.bstorm.correction.streams.service;

public class MagasinFiller {

    public static void fill(Magasin m){

        m.addProduct(new Produit(
                "velo",
                182.5,
                "ting",
                Produit.Type.GROS,
                50
        ));
        m.addProduct(new Produit(
                "voiture",
                25999,
                "ting",
                Produit.Type.GROS,
                10
        ));
        m.addProduct(new Produit(
                "modèle réduit",
                12.5,
                "ting",
                Produit.Type.PETIT,
                300
        ));
        m.addProduct(new Produit(
                "fauteuil",
                680.5,
                "salon-cool",
                Produit.Type.GROS,
                40
        ));
        m.addProduct(new Produit(
                "lampe",
                30,
                "salon-cool",
                Produit.Type.PETIT,
                80
        ));
        m.addProduct(new Produit(
                "poireau",
                1,
                "cuisine-cool",
                Produit.Type.COMESTIBLE,
                30
        ));
        m.addProduct(new Produit(
                "tomate",
                .5,
                "cuisine-cool",
                Produit.Type.COMESTIBLE,
                32
        ));
        m.addProduct(new Produit(
                "râpe",
                8.99,
                "cuisine-cool",
                Produit.Type.PETIT,
                70
        ));
        m.addProduct(new Produit(
                "pizza",
                12.5,
                "pizza-cool",
                Produit.Type.COMESTIBLE,
                50
        ));
        m.addProduct(new Produit(
                "four à pizza",
                4995,
                "pizza-cool",
                Produit.Type.GROS,
                5
        ));
    }
}
