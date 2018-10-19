package com.mechanitis.demo.client.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.function.Consumer;

import static javafx.application.Platform.runLater;

public class SymbolData implements Consumer<String> {
    private final ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
    private final StockStats stockStats;
    private long tick = 0;
    private double maxPrice = 0;

    public SymbolData(StockStats stockStats) {
        this.stockStats = stockStats;
    }

    @Override
    public void accept(String message) {
        System.out.println("price = [" + message + "]");
        Double price = Double.valueOf(message);
        stockStats.update(price);
//        stockStats.setMaxPrice(tick);
        runLater(() -> {
            data.add(new XYChart.Data<>(String.valueOf(tick++), price));
        });
    }

    public ObservableList<XYChart.Data<String, Number>> getData() {
        return data;
    }

}

