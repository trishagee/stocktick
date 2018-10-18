module com.mechanitis.demo.duel.services.stub {
    requires java.logging;
    requires rsocket.transport.netty;
    requires rsocket.core;
    requires reactor.core;
    // Netty needs unsafe
    requires jdk.unsupported;

    exports com.mechanitis.demo.duel.services.stub;
}