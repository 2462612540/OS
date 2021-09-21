package com.xjl.jdk.java8.samples.stream;

import java.util.Optional;

/**
 * @description TODO
 * @param: null
 * @date: 2021/9/16 23:41
 * @return:
 * @author: xjl
 */
public class Optional1 {

    public static void main(String[] args) {
        //of的函数必须要分非空的一个值
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

}