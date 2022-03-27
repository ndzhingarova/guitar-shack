package com.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SalesDataTest {
    @Test
    public void returnsProductSalesTotalForDateRange() {
        final String baseUrl = "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales";
        SalesData salesData = new GuitarShackSalesData(
                new DataService(baseUrl,
                        HttpClients.createDefault(),
                        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)));

        assertThat(
                salesData.forDateRange(811, LocalDate.parse("2021-01-01"), LocalDate.parse("2021-12-31")),
                greaterThan(0));
    }
}
