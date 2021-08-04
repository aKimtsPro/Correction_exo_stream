package com.bstorm.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamParal {

    public static void main(String[] args) {

        Stream<Double> s = Stream.generate(Math::random);

        s.filter((n) -> n > 20)
                .parallel()
                .peek((e) -> System.out.println(Thread.currentThread().getName()+ " - peeking - " + e))
                .limit(20)
//                .sequential()
                .forEach(System.out::println);

    }

}
