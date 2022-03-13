package com.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SalesHistoryTest {

    @Test
    public void startDateThirtyDaysAgo() {

        LocalDate startDate = LocalDate.parse("2022-01-28");
        SalesData salesData = mock(SalesData.class);

        Today today = () -> LocalDate.parse("2022-02-27");

        SalesHistory salesHistory = new ThirtyDaysSalesHistory(salesData, today);
        Product product = new Product(0,0);
        salesHistory.totalSales(product);

        verify(salesData).forDateRange(anyInt(), eq(startDate), any());
    }

    @Test
    public void endDateToday() {
        LocalDate endDate = LocalDate.parse("2022-03-13");
        SalesData salesData = mock(SalesData.class);

        Today today = () -> LocalDate.parse("2022-03-13");

        SalesHistory salesHistory = new ThirtyDaysSalesHistory(salesData, today);
        Product product = new Product(0,0);
        salesHistory.totalSales(product);

        verify(salesData).forDateRange(anyInt(), any(), eq(endDate));
    }
}
