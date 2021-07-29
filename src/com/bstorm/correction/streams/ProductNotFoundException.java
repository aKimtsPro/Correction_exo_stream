package com.bstorm.correction.streams;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Le produit n'a pas pu être trouvé");
    }
}
