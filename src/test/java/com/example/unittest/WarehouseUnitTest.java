package com.example.unittest;

import com.example.abstractTests.AbstractWarehouseTest;
import com.example.Product;
import com.example.Warehouse;

public class WarehouseUnitTest extends AbstractWarehouseTest {
    @Override
    protected Warehouse createWarehouse() {
        return id -> new Product(811, 0, 14);
    }
}
