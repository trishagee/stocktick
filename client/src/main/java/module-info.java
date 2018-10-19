module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javax.websocket.api;
    requires spring.webflux;
    requires reactor.core;

    exports com.mechanitis.demo.client to javafx.graphics, javafx.fxml;

    //put this into its own directory so we don't have to have reflective access to everything
    opens com.mechanitis.demo.client.fxmodel to javafx.fxml, javafx.base;

}