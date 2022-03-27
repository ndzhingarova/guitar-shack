package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DataService<T> {
    private final String baseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public DataService(String baseUrl, HttpClient httpClient, ObjectMapper objectMapper) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    T getObject(String queryString, Class<T> valueType) {
        T result = null;
        HttpGet request = new HttpGet(baseUrl + queryString);
        try {
            HttpResponse response = httpClient.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());

            result = objectMapper.readValue(responseString, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
