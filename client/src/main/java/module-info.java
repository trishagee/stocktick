module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javax.websocket.api;
    requires spring.webflux;
    requires reactor.core;

    exports com.mechanitis.demo.client to javafx.graphics, javafx.fxml;
}