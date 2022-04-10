package com.example.unittest;

import com.example.abstractTests.AbstractSalesDataTest;
import com.example.SalesData;

public class SalesDataUnitTest extends AbstractSalesDataTest {
    @Override
    protected SalesData createSalesData() {
        return (productId, startDate, endDate) -> 20;
    }
}
