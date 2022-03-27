package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GuitarShackSalesData implements SalesData {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final DataService dataService;

    public GuitarShackSalesData(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public int forDateRange(int productId, LocalDate startDate, LocalDate endDate) {
        
        final String queryString = "?productId=" + productId + "&startDate=" + startDate.format(dateTimeFormatter) + "&endDate=" + endDate.format(dateTimeFormatter) + "&action=total";

        SalesTotal salesTotal = dataService.getObject(queryString);

        return salesTotal.getTotal();
    }

}
