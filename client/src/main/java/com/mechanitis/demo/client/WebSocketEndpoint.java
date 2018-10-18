package com.mechanitis.demo.client;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

public class WebSocketEndpoint {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        WebSocketClient socketClient = new ReactorNettyWebSocketClient();

        URI uri = URI.create("ws://localhost:8083/MDB/");

        socketClient.execute(uri, (WebSocketSession session) -> {

            Mono<WebSocketMessage> out = Mono.just(session.textMessage("test"));

            Flux<String> in = session.receive()
                                     .map(WebSocketMessage::getPayloadAsText)
                                     .doOnEach(incomingStockTickerString -> sendToChart(incomingStockTickerString));

            return session.send(out)
                          .thenMany(in)
                          .then();
        }).subscribe();
        countDownLatch.await();
    }

    private static void sendToChart(Signal<String> incomingStockTickerString) {
        System.out.println(incomingStockTickerString.get());
    }
}
