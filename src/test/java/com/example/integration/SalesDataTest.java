package com.example.integration;

import com.example.abstractTests.AbstractSalesDataTest;
import com.example.DataService;
import com.example.GuitarShackSalesData;
import com.example.SalesData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;

public class SalesDataTest extends AbstractSalesDataTest {

    @Override
    protected SalesData createSalesData() {
        final String baseUrl = "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales";
        SalesData salesData = new GuitarShackSalesData(
                new DataService<>(baseUrl,
                        HttpClients.createDefault(),
                        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)));
        return salesData;
    }
}
