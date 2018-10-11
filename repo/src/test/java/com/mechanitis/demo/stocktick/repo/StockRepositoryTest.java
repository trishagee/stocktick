package com.mechanitis.demo.stocktick.repo;

import org.assertj.core.api.Assertions;
import org.bson.Document;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Instant;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StockRepositoryTest {

    @Autowired
    ReactiveMongoTemplate mongoOperations;

    @Autowired
    StockRepository repository;


    @Test
    void test() {
        // given
        long id = Instant.now().toEpochMilli();
        Document objectToSave = new Document().append("id", id)
                                              .append("key", "value");

        // when
        mongoOperations.save(objectToSave, "collection").block();

        // then
        Query findById = query(where("id").is(id));
        Document dbObject = mongoOperations.findOne(findById, Document.class, "collection").block();

        Assertions.assertThat(dbObject).extracting("key").containsOnly("value");
    }

    @Test
    @Disabled
    public void shouldGetStockBySymbol() {
        System.out.println("repository = " + repository);
        System.out.println("repository = " + repository.findAll().toStream().collect(Collectors.toList()));

        Flux<StockTicker> mdb1 = repository.findBySymbol("MDB");
        Disposable mdb = mdb1.subscribe();
        mdb.dispose();
        StepVerifier.create(mdb1)
                    .expectNext(new StockTicker("MDB"))
                    .verifyComplete();


    }
}