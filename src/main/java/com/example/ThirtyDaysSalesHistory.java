package com.example;

public class ThirtyDaysSalesHistory implements SalesHistory {
    private final SalesData salesData;
    private final Today today;

    public ThirtyDaysSalesHistory(SalesData salesData, Today today) {
        this.salesData = salesData;
        this.today = today;
    }

    @Override
    public int totalSales(Product product) {
        return salesData.forDateRange(0, today.get().minusDays(30), null);
    }
}
