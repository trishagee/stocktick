package com.mechanitis.demo.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ChartController {
    @FXML
    public LineChart<String, Number> stockticker;

    //currently only supports a single symbol/series on the chart
    @SuppressWarnings("unchecked")
    void setData(final SymbolData chartData) {
        final XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setData(chartData.getData());
        final ObservableList<XYChart.Series<String, Number>> seriesList = FXCollections.observableArrayList(series);
        stockticker.setData(seriesList);
    }
}
