package com.mechanitis.demo.client;

import javafx.scene.chart.LineChart;

public class StockController {
    public LineChart stockticker;
    private StockChartData chartData;

    public void setData(StockChartData chartData) {

        this.chartData = chartData;
    }
}
