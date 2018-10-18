package com.mechanitis.demo.duel.services.stub;

import io.rsocket.*;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

public class ExampleServer {
    public static void main(String[] args) {
        RSocketFactory.receive()
                      .frameDecoder(Frame::retain)
                      .acceptor(new PingHandler())
                      .transport(TcpServerTransport.create(7878))
                      .start()
                      .block()
                      .onClose();
    }

    private static class PingHandler implements SocketAcceptor {
        @Override
        public Mono<RSocket> accept(ConnectionSetupPayload setup, RSocket sendingSocket) {
            return null;
        }
    }
}
