package com.example;

import abstractTests.AbstractWarehouseTest;

public class WarehouseUnitTest extends AbstractWarehouseTest {
    @Override
    protected Warehouse createWarehouse() {
        return id -> new Product(811, 0, 14);
    }
}
