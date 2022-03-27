package com.example;

public class Product {
    private int stock;
    private int leadTime;
    private int id;

    public Product() {
    }

    public Product(int id, int stock, int leadTime) {
        this.id = id;
        this.stock = stock;
        this.leadTime = leadTime;
    }

    public int getStock() {
        return stock;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public int getId() {
        return id;
    }
}
