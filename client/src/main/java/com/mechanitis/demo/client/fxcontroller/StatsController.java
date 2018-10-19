package com.mechanitis.demo.client.fxcontroller;

import com.mechanitis.demo.client.data.StockStats;
import com.mechanitis.demo.client.fxmodel.StockInfoItem;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class StatsController {
    @FXML
    public TableView<StockInfoItem> stats;

    void setData(StockStats stockStats) {
        stats.setItems(stockStats.getData());
    }
}
