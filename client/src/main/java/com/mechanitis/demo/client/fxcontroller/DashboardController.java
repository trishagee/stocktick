package com.mechanitis.demo.client.fxcontroller;

import com.mechanitis.demo.client.data.StockStats;
import com.mechanitis.demo.client.data.SymbolData;
import javafx.fxml.FXML;

public class DashboardController {
    @FXML
    private ChartController chartController;
    @FXML
    private StatsController statsController;

    public void setData(SymbolData symbolData, StockStats stockStats) {
        chartController.setData(symbolData);
        statsController.setData(stockStats);
    }
}
