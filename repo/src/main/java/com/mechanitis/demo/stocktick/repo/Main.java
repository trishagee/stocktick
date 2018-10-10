package com.mechanitis.demo.stocktick.repo;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Main extends AbstractReactiveMongoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "stocktick";
    }

}