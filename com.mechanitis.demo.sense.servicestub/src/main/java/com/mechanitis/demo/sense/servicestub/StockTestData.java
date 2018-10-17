package com.mechanitis.demo.sense.servicestub;

import java.util.Random;

public class StockTestData {

    private static final Random random = new Random();

    public static void main(String[] args) {
        StubService stubUserService = new StubService("/MDB/", 8083, () -> String.valueOf(random.nextInt(10)));
        stubUserService.run();
    }

}
