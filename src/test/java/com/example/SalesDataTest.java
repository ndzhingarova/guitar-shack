package com.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SalesDataTest {
    @Test
    public void returnsProductSalesTotalForDateRange() {
        SalesData salesData = new GuitarShackSalesData("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales");

        assertThat(
                salesData.forDateRange(811, LocalDate.parse("2021-01-01"), LocalDate.parse("2021-12-31")),
                greaterThan(0));
    }
}
