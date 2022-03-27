package com.example;

import org.junit.Assert;
import org.junit.Test;

public class RestockLevelTest {

    @Test
    public void leadTimeMultipliedByAverageDailySales() {
        SalesHistory salesHistory = product -> 15;
        Product product = new Product(811, 7, 14);
        RestockLevel restockLevel = new ProductRestockLevel(salesHistory);

        Assert.assertEquals(7, restockLevel.forProduct(product));
    }
}
