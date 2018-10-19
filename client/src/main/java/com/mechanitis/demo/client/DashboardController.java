package com.mechanitis.demo.client;

import javafx.fxml.FXML;

public class DashboardController {
    @FXML
    public ChartController chartController;

    public void setData(SymbolData symbolData) {
        chartController.setData(symbolData);
    }
}
