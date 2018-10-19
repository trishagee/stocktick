package com.mechanitis.demo.client.data;

import com.mechanitis.demo.client.fxmodel.StockInfoItem;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockStats {
    private final ObservableList<StockInfoItem> stockInfoItems = FXCollections.observableArrayList();

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
        stockInfoItems.add(new StockInfoItem("Min Price", this.minPrice));
        stockInfoItems.add(new StockInfoItem("Max Price", this.maxPrice));
        stockInfoItems.add(new StockInfoItem("Average Price", this.averagePrice));
        stockInfoItems.add(new StockInfoItem("Open Price", this.openPrice));
        stockInfoItems.add(new StockInfoItem("Close Price", this.closePrice));
    }

    public ObservableList<StockInfoItem> getData() {
        return stockInfoItems;
    }

    void update(double price) {
        System.out.println("StockStats.update");
        checkAndUpdateMaxPrice(price);
    }

    private void checkAndUpdateMaxPrice(double price) {
        if (maxPrice.get() < price) {
            System.out.println("maxprice = [" + price + "]");
            maxPrice.set(price);
        }
    }
}
