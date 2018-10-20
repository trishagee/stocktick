package com.mechanitis.demo.client;

import com.mechanitis.demo.client.data.StockStats;
import com.mechanitis.demo.client.data.SymbolData;
import com.mechanitis.demo.client.fxcontroller.DashboardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;


public class StockTicker extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // all models created in advance
        StockStats stockStats = new StockStats(0, 10, 4.3, 8.7, 8.9);
        SymbolData chartData = new SymbolData(stockStats);
        connect(chartData);

        // initialise the UI
        URL resource = getClass().getResource("/com/mechanitis/demo/client/dashboard.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        primaryStage.setTitle("Stock Prices Dashboard");
        Scene scene = new Scene(loader.load(), 900, 700);
        scene.getStylesheets().add(getClass().getResource("/com/mechanitis/demo/client/default.css").toString());

        // wire up the models to the controllers
        DashboardController dashboardController = loader.getController();
//        ChartController controller = loader.getController();
        dashboardController.setData(chartData, stockStats);

        // let's go!
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connect(SymbolData chartData) {
        WebSocketClient socketClient = new ReactorNettyWebSocketClient();

        URI uri = URI.create("ws://localhost:8083/MDB/");

        socketClient.execute(uri, (WebSocketSession session) -> {

            Mono<WebSocketMessage> out = Mono.just(session.textMessage("test"));

            Flux<String> in = session.receive()
                                     .map(WebSocketMessage::getPayloadAsText)
                                     //there's a better way to do this
                                     .doOnEach(incomingStockTickerString -> chartData.accept(incomingStockTickerString.get()));

            return session.send(out)
                          .thenMany(in)
                          .then();
        }).subscribe();
    }


    public static void main(String[] args) {
        launch();
    }

}