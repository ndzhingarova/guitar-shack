package com.example.unittest;

import com.example.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SalesHistoryTest {

    private SalesData salesData;
    private SalesHistory salesHistory;
    private Product product;

    @Before
    public void setUp() {
        salesData = mock(SalesData.class);
        when(salesData.forDateRange(anyInt(), any(), any())).thenReturn(15);
        Today today = () -> LocalDate.parse("2022-02-27");
        salesHistory = new ThirtyDaysSalesHistory(salesData, today);
        product = new Product(811, 0, 0);
    }

    @Test
    public void startDateThirtyDaysAgo() {
        LocalDate startDate = LocalDate.parse("2022-01-28");
        salesHistory.last30DaysSales(product);

        verify(salesData).forDateRange(anyInt(), eq(startDate), any());
    }

    @Test
    public void endDateToday() {
        LocalDate endDate = LocalDate.parse("2022-02-27");
        salesHistory.last30DaysSales(product);

        verify(salesData).forDateRange(anyInt(), any(), eq(endDate));
    }

    @Test
    public void returnSalesTotal() {
        assertEquals(15, salesHistory.last30DaysSales(product));
    }
}
