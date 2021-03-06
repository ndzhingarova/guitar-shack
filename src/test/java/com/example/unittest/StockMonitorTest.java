package com.example.unittest;

import com.example.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class StockMonitorTest {

    @Test
    public void sendAlertOnSaleWhenRestockLevelReached () {
        Product product = new Product(811, 25, 14);
        Warehouse warehouse = id -> product;
        RestockLevel restockLevel = product1 -> 24;
        Alert alert = mock(Alert.class);
        StockMonitor stockMonitor = new StockMonitor(alert, warehouse, restockLevel);

        stockMonitor.onSale(811, 1);

        verify(alert).send("Please order more of product 811");
    }

    @Test
    public void noAlertSentWhenRestockLevelNotReached () {
        Product product = new Product(811, 26, 14);
        Warehouse warehouse = id -> product;
        RestockLevel restockLevel = product1 -> 24;
        Alert alert = mock(Alert.class);
        StockMonitor stockMonitor = new StockMonitor(alert, warehouse, restockLevel);

        stockMonitor.onSale(811, 1);

        verify(alert, never()).send(any());
    }
}
