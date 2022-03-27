package integration;

import abstractTests.AbstractWarehouseTest;
import com.example.DataService;
import com.example.GuitarShackWarehouse;
import com.example.Warehouse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;

public class WarehouseTest extends AbstractWarehouseTest {

    @Override
    protected Warehouse createWarehouse() {
        String baseUrl = "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product";
        Warehouse warehouse = new GuitarShackWarehouse(
                new DataService<>(
                        baseUrl,
                        HttpClients.createDefault(),
                        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)));
        return warehouse;
    }
}
