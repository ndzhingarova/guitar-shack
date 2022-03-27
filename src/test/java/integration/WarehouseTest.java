package integration;

import com.example.DataService;
import com.example.GuitarShackWarehouse;
import com.example.Product;
import com.example.Warehouse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

public class WarehouseTest {

    @Test
    public void findProduct() {
        String baseUrl = "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product";
        Warehouse warehouse = new GuitarShackWarehouse(
                new DataService<>(
                        baseUrl,
                        HttpClients.createDefault(),
                        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)));
        Product product = warehouse.findById(811);

        Assert.assertEquals(811, product.getId());
    }
}
