module client {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.mechanitis.demo.client to javafx.graphics;
    opens com.mechanitis.demo.client;
}