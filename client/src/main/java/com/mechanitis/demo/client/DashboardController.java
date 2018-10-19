package com.mechanitis.demo.client;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class DashboardController {
    @FXML
    public ChartController chartController;
    @FXML
    public StatsController statsController;


    void setData(SymbolData symbolData, StockStats stockStats) {
        chartController.setData(symbolData);
        statsController.setData(stockStats);
    }
}
