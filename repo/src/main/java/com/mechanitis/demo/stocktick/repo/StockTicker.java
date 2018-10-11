package com.mechanitis.demo.stocktick.repo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "history")
public class StockTicker {
    private String symbol;

    public StockTicker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockTicker that = (StockTicker) o;
        return Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "StockTicker{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
