package com.example;

import java.time.LocalDate;

public interface SalesData {
    int forDateRange(int productId, LocalDate startDate, LocalDate endDate);
}
