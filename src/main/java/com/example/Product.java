package com.example;

public class Product {
    private final int stock;
    private final int leadTime;

    public Product(int stock, int leadTime) {

        this.stock = stock;
        this.leadTime = leadTime;
    }

    public int getStock() {
        return stock;
    }

    public int getLeadTime() {
        return leadTime;
    }
}
