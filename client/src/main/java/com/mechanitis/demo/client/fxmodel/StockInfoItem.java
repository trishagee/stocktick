package com.mechanitis.demo.client.fxmodel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockInfoItem {
    private SimpleStringProperty label;
    private SimpleDoubleProperty value;

    public StockInfoItem(String label, SimpleDoubleProperty value) {
        this.label = new SimpleStringProperty(label);
        this.value = value;
    }

    //IntelliJ generates both the property and getter methods!
    public SimpleStringProperty getLabelProperty() {
        return label;
    }

    public SimpleDoubleProperty getValueProperty() {
        return value;
    }

    public String getLabel() {
        return label.get();
    }

    public double getValue() {
        return value.get();
    }

}
