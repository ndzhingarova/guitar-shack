package com.example;

import abstractTests.AbstractSalesDataTest;

public class SalesDataUnitTest extends AbstractSalesDataTest {
    @Override
    protected SalesData createSalesData() {
        return (productId, startDate, endDate) -> 20;
    }
}
