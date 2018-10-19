package com.mechanitis.demo.client.data;

import com.mechanitis.demo.client.fxmodel.StockInfoItem;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockStats {
    //needs to be the JavaFX property here as this is the one that's going to be watched and changed.
    private final SimpleDoubleProperty maxPrice;
    private final SimpleDoubleProperty minPrice;
    private final SimpleDoubleProperty averagePrice;
    private final SimpleDoubleProperty openPrice;
    private final SimpleDoubleProperty closePrice;

    public StockStats(double maxPrice, double minPrice, double averagePrice, double openPrice, double closePrice) {
        this.maxPrice = new SimpleDoubleProperty(maxPrice);
        this.minPrice = new SimpleDoubleProperty(minPrice);
        this.averagePrice = new SimpleDoubleProperty(averagePrice);
        this.openPrice = new SimpleDoubleProperty(openPrice);
        this.closePrice = new SimpleDoubleProperty(closePrice);
    }

    public ObservableList<StockInfoItem> getData() {
        ObservableList<StockInfoItem> stockInfoItems = FXCollections.observableArrayList();
        stockInfoItems.add(new StockInfoItem("Min Price", minPrice));
        stockInfoItems.add(new StockInfoItem("Max Price", maxPrice));
        stockInfoItems.add(new StockInfoItem("Average Price", averagePrice));
        stockInfoItems.add(new StockInfoItem("Open Price", openPrice));
        stockInfoItems.add(new StockInfoItem("Close Price", closePrice));
        return stockInfoItems;
    }
}
