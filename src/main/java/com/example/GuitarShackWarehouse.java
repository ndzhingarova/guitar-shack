package com.example;

public class GuitarShackWarehouse implements Warehouse {


    private final DataService<Product> productDataService;

    public GuitarShackWarehouse(DataService<Product> productDataService) {
        this.productDataService = productDataService;
    }

    @Override
    public Product findById(int id) {
        return productDataService.getObject("?id=" + id, Product.class);
    }
}
