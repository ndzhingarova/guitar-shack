package com.example;

public class StockMonitor {
    private final Alert alert;
    private final Warehouse warehouse;
    private final RestockLevel restockLevel;

    public StockMonitor(Alert alert, Warehouse warehouse, RestockLevel restockLevel) {

        this.alert = alert;
        this.warehouse = warehouse;
        this.restockLevel = restockLevel;
    }

    public void onSale(int productId, int quantity) {
        Product product = warehouse.findById(productId);
        if (product.getStock() - quantity <= restockLevel.forProduct(product)) {
            alert.send("Please order more of product " + productId);
        }
    }
}
