package com.example.abstractTests;


import com.example.Product;
import com.example.Warehouse;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractWarehouseTest {
    @Test
    public void findProduct() {
        Warehouse warehouse = createWarehouse();
        Product product = warehouse.findById(811);

        Assert.assertEquals(811, product.getId());
    }

    protected abstract Warehouse createWarehouse();
}
