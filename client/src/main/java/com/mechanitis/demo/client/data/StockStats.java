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
    private int numberOfPrices = 0;

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
        checkAndUpdateMaxPrice(price);
        checkAndUpdateMinPrice(price);
        updateAveragePrice(price);
    }

    private void checkAndUpdateMaxPrice(double price) {
        if (maxPrice.get() < price) {
            maxPrice.set(price);
        }
    }

    private void checkAndUpdateMinPrice(double price) {
        if (minPrice.get() > price) {
            minPrice.set(price);
        }
    }

    //this needs a test
    private void updateAveragePrice(double price) {
        double prevMean = averagePrice.get();
        double newMean = ((prevMean * numberOfPrices) + price) / ++numberOfPrices;
        averagePrice.set(newMean);
    }
    //also need to change the UI to limit this to 2dp

}
