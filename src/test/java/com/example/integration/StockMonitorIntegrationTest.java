package com.example.integration;

import static org.mockito.Mockito.*;

import com.example.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.time.LocalDate;

public class StockMonitorIntegrationTest {

    private static final String productBaseUrl = "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product";
    private static final String salesBaseURl = "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales";

    @Test
    public void sendAlertOnSaleWhenRestockLevelReached() {

        Alert alert = mock(Alert.class);
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Today today = () -> LocalDate.parse("2021-04-23");
        StockMonitor stockMonitor = new StockMonitor(
                alert,
                new GuitarShackWarehouse(
                        new DataService<Product>(productBaseUrl, httpClient, objectMapper)),
                new ProductRestockLevel(
                        new ThirtyDaysSalesHistory(
                                new GuitarShackSalesData(
                                        new DataService<SalesTotal>(salesBaseURl, httpClient, objectMapper)
                                ), today
                        )
                )
        );

        stockMonitor.onSale(811,26);

        verify(alert).send("Please order more of product 811");
    }
}
