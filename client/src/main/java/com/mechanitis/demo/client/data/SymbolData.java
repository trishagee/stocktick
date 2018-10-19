package com.mechanitis.demo.client.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.function.Consumer;

import static javafx.application.Platform.runLater;

public class SymbolData implements Consumer<String> {
    private final ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
    private long tick = 0;

    @Override
    public void accept(String price) {
        System.out.println("price = [" + price + "]");
        runLater(() -> data.add(new XYChart.Data<>(String.valueOf(tick++), Integer.valueOf(price))));
    }

    public ObservableList<XYChart.Data<String, Number>> getData() {
        return data;
    }

}

