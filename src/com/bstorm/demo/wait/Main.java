package com.bstorm.demo.wait;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Test t = new Test();
        ExecutorService es = new ThreadPoolExecutor(4, 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        es.execute(t::m1);
        es.execute(t::m1);
        es.execute(t::m1);
        es.execute(t::m2);
    }
}
