module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javax.websocket.api;

    exports com.mechanitis.demo.client to javafx.graphics;
    opens com.mechanitis.demo.client;
}