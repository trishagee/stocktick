package com.mechanitis.demo.client;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

public class StockController {
    @FXML
    public LineChart<String, Number> stockticker;
    private StockChartData chartData;

    public void setData(StockChartData chartData) {
        stockticker.getData().add(chartData.getData());
    }
}
