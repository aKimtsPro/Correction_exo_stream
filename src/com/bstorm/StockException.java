package com.bstorm;

public class StockException extends RuntimeException {

    private final int addedStock;
    private final int currentStock;
    private final int limit;

    public StockException(int toAdd, int currentStock, int limit) {
        super("Impossible d'ajouter du stock au delà de la limite");
        this.addedStock = toAdd;
        this.currentStock = currentStock;
        this.limit = limit;
    }

    public int getAddedStock() {
        return addedStock;
    }

    public int getLimit() {
        return limit;
    }

    public int getCurrentStock() {
        return currentStock;
    }
}
