package com.example.abstractTests;

import com.example.SalesData;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public abstract class AbstractSalesDataTest {
    @Test
    public void returnsProductSalesTotalForDateRange() {
        SalesData salesData = createSalesData();

        assertThat(
                salesData.forDateRange(811, LocalDate.parse("2021-01-01"), LocalDate.parse("2021-12-31")),
                greaterThan(0));
    }

    protected abstract SalesData createSalesData();

}
