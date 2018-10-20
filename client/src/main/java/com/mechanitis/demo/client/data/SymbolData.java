package com.mechanitis.demo.client.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

import java.util.*;
import java.util.function.Consumer;

import static javafx.application.Platform.runLater;

public class SymbolData implements Consumer<String> {
    //makes sense for this to be an array actually, since I don't want to change
    //the length I want to replace the items
    //although... actually that's not true because I need to add to the end and remove from the front
    private final Queue data = new ArrayDeque<Data<String, Number>>(30);
    private final ObservableList<Data<String, Number>> observableData = FXCollections.observableArrayList(data);
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
        System.out.println("data.size() = " + data.size());
        runLater(() -> {
            data.add(new Data<String, Number>(String.valueOf(tick++), price));
        });
    }

    public ObservableList<Data<String, Number>> getData() {
        return observableData;
    }

}

