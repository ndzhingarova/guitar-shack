package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DataService {
    private final String baseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public DataService(String baseUrl, HttpClient httpClient, ObjectMapper objectMapper) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    SalesTotal getObject(String queryString) {
        SalesTotal salesTotal = new SalesTotal();
        HttpGet request = new HttpGet(baseUrl + queryString);
        try {
            HttpResponse response = httpClient.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());

            salesTotal = objectMapper.readValue(responseString, SalesTotal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesTotal;
    }
}
