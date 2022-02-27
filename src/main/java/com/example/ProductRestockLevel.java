package com.example;

public class ProductRestockLevel implements RestockLevel {
    private final SalesHistory salesHistory;

    public ProductRestockLevel(SalesHistory salesHistory) {

        this.salesHistory = salesHistory;
    }

    @Override
    public int forProduct(Product product) {
        return (int) ((salesHistory.totalSales(product) / 30.0) * (double) product.getLeadTime());
    }
}
