package com.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GuitarShackSalesData implements SalesData {

    private final String baseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public GuitarShackSalesData(String baseUrl) {
        this.baseUrl = baseUrl;
        httpClient = HttpClients.createDefault();
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public int forDateRange(int productId, LocalDate startDate, LocalDate endDate) {
        SalesTotal salesTotal = new SalesTotal();
        final String uri = baseUrl + "?productId=" + productId + "&startDate=" + startDate.format(dateTimeFormatter) + "&endDate=" + endDate.format(dateTimeFormatter) + "&action=total";
        HttpGet request = new HttpGet(uri);
        try {
            HttpResponse response = httpClient.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());

            salesTotal = objectMapper.readValue(responseString, SalesTotal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesTotal.getTotal();
    }
}
