package com.bstorm.service;

import com.bstorm.ProductNotFoundException;
import com.bstorm.StockException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Magasin {

    private final List<Produit> produits = new ArrayList<>();
    private final String nom;
    private final int stockLimit;

    public Magasin(String nom, int stockLimit) {
        this.nom = nom;
        this.stockLimit = stockLimit;
    }

    public String getNom() {
        return nom;
    }
    public int getStockLimit() {
        return stockLimit;
    }

    private int getStockSize(){
        return produits.stream()
                .map(Produit::getStock)
                .reduce(0, Integer::sum);
    }

    public List<Produit> getProduits() {
        return new ArrayList<>(produits);
    }


    public Produit getProductByName(String name){
        return produits.stream()
                .filter(produit -> produit.getNom().equals(name))
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }

    // region modifyList
    public void addProduct(Produit toAdd){
        int stockSize = getStockSize();
        if( stockSize + toAdd.getStock() > stockLimit)
            throw new StockException(toAdd.getStock(), stockSize, stockLimit);

        produits.add(toAdd);
    }
    public void deleteProduct(Produit toDelete){
        produits.remove(toDelete);
    }
    public void addStock(Produit produit, int toAdd){
        int stockSize = getStockSize();
        if( stockSize + toAdd > stockLimit)
            throw new StockException(toAdd, stockSize, stockLimit);

        if( !produits.contains(produit) )
            throw new ProductNotFoundException();

        produit.addToStock(toAdd);
    }
    // endregion

    // region tri
    public List<Produit> getStockSortedByQtt(boolean desc){
        Comparator<Produit> comparator = Comparator.comparingInt(Produit::getStock);
        if(desc)
            comparator = comparator.reversed();

        return produits.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
    public List<Produit> getStockSortedByPrice(boolean desc){
        Comparator<Produit> comparator = Comparator.comparingDouble(Produit::getPrix);
        if(desc)
            comparator = comparator.reversed();

        return produits.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
    public List<Produit> getStockSortedByType(boolean desc){
        Comparator<Produit> comparator = Comparator.comparing(p -> p.getType().name());
        if(desc)
            comparator = comparator.reversed();

        return produits.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
    // endregion

    public List<String> getBrands(){
        return produits.stream()
                .map(Produit::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }
    public List<Produit> getByBrand(String brand){
        return produits.stream()
                .filter((prod)-> prod.getBrand().equals(brand))
                .collect(Collectors.toList());
    }
    public List<Produit> search(Double minPrix, Double maxPrix, Produit.Type type, String nom){
        return produits.stream()
                .filter(produit -> minPrix == null || produit.getPrix() >= minPrix)
                .filter(produit -> maxPrix == null || produit.getPrix() <= maxPrix)
                .filter(produit -> type == null || produit.getType() == type)
                .filter(produit -> nom == null || produit.getNom().contains(nom))
                .collect(Collectors.toList());
    }

    public boolean lowStockPresent(){
        return produits.stream()
                .anyMatch(p -> p.getStock() <= 10);
    }
    public List<Produit> getByLowStock(){
        return produits.stream()
                .filter(p -> p.getStock() <= 10)
                .collect(Collectors.toList());
    }

}
