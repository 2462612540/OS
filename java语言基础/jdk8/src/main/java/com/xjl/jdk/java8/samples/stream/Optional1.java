package com.xjl.jdk.java8.samples.stream;

import java.util.Optional;

/**
 * @description TODO
 * @param: null
 * @date: 2021/9/14 7:34
 * @return:
 * @author: xjl
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

}