package com.bstorm.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorPres {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<String> result = es.submit(() -> {
            return "bonjour";
        });


    }

}
