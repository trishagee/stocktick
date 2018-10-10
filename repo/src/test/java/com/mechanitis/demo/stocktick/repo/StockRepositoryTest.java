package com.mechanitis.demo.stocktick.repo;

import org.assertj.core.api.Assertions;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.print.Doc;
import java.time.Instant;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StockRepositoryTest {

    @Autowired
    ReactiveMongoTemplate mongoOperations;

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
    public void shouldGetStockBySymbol() {
    }
}