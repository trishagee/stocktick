package com.mechanitis.demo.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.concurrent.Flow;

import static javafx.application.Platform.runLater;

public class SymbolData implements Flow.Subscriber<String> {
    private final ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
    private long tick = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println(subscription);
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String price) {
        System.out.println("price = [" + price + "]");
        runLater(() -> data.add(new XYChart.Data<>(String.valueOf(tick++), Integer.valueOf(price))));
    }

    ObservableList<XYChart.Data<String, Number>> getData() {
        return data;
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

}

