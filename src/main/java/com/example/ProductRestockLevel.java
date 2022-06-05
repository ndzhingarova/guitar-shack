package com.example;

public class ProductRestockLevel implements RestockLevel {
    private final SalesHistory salesHistory;

    public ProductRestockLevel(SalesHistory salesHistory) {

        this.salesHistory = salesHistory;
    }

    @Override
    public int forProduct(Product product) {
        final double dailySales = salesHistory.last30DaysSales(product) / 30.0;
        final double leadTimeExpectedSales = dailySales * (double) product.getLeadTime();
        return (int) leadTimeExpectedSales;
    }
}
