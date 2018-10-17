package com.mechanitis.demo.client;

import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;

import static java.time.LocalTime.now;

public class StockChartData implements Flow.Subscriber<String> {
        private final XYChart.Series<String, Double> dataSeries = new XYChart.Series<>();
        private final Map<Integer, Integer> minuteToDataPosition = new HashMap<>();

        public StockChartData() {
            int nowMinute = now().getMinute();
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(String price) {
//            if (mood.equals("HAPPY")) {
//                int x = now().getMinute();
//
//                Integer dataIndex = minuteToDataPosition.get(x);
//                XYChart.Data<String, Double> barForNow = dataSeries.getData().get(dataIndex);
//                barForNow.setYValue(barForNow.getYValue() + 1);
//            }
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {

        }

}

