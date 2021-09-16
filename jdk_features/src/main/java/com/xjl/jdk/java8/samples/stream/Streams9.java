package com.xjl.jdk.java8.samples.stream;

import java.util.Arrays;

/**
 * @description TODO
 * @param: null
 * @date: 2021/9/16 23:41
 * @return:
 * @author: xjl
 */
public class Streams9 {

    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        // C1
        // C2
    }
}
