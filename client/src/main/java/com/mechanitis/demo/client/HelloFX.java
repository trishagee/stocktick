package com.mechanitis.demo.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;


public class HelloFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // all models created in advance
//        StockChartData chartData = new StockChartData();

        // wire up the models to the services they're getting the data from
//        ClientEndpoint endpoint = new ClientEndpoint("ws://localhost:8083/users/");
//        endpoint.subscribe(chartData);


        // initialise the UI
        URL resource = getClass().getResource("/com/mechanitis/demo/client/container.fxml");
        System.out.println("resource = " + resource);
        FXMLLoader loader = new FXMLLoader(resource);
        primaryStage.setTitle("Stock Prices Dashboard");
        Scene scene = new Scene(loader.load(), 900, 700);
        scene.getStylesheets().add(getClass().getResource("/com/mechanitis/demo/client/default.css").toString());

        // wire up the models to the controllers
//        DashboardController dashboardController = loader.getController();
//        dashboardController.setData(chartData);

        // let's go!
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}