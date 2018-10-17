package com.mechanitis.demo.client;

import javafx.scene.chart.XYChart;

import java.util.concurrent.Flow;

public class StockChartData implements Flow.Subscriber<String> {
    private XYChart.Series<String, Number> data = new XYChart.Series<>();
    private long tick = 0;

    XYChart.Series<String, Number> getData() {
        return data;
    }

    public StockChartData() {
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println(subscription);
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String price) {
        System.out.println("price = [" + price + "]");
        data.getData().add(new XYChart.Data<>(String.valueOf(tick++), Integer.valueOf(price)));
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

}

