package com.xjl.jdk.java8.samples.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * @description TODO 
  * @param: null
 * @date: 2021/9/14 7:34
 * @return: 
 * @author: xjl
*/
public class Streams8 {

    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "a3")
            .stream()
            .findFirst()
            .ifPresent(System.out::println);

        Stream.of("a1", "a2", "a3")
            .map(s -> s.substring(1))
            .mapToInt(Integer::parseInt)
            .max()
            .ifPresent(System.out::println);

        IntStream.range(1, 4)
            .mapToObj(i -> "a" + i)
            .forEach(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
            .map(n -> 2 * n + 1)
            .average()
            .ifPresent(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
            .mapToInt(Double::intValue)
            .mapToObj(i -> "a" + i)
            .forEach(System.out::println);

    }
}
