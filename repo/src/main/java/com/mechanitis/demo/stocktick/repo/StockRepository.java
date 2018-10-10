package com.mechanitis.demo.stocktick.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

interface StockRepository extends ReactiveMongoRepository<StockTicker, String> {

    @Tailable
    Flux<StockTicker> findBySymbol(String symbol) ;
}
