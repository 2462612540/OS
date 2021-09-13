package com.xjl.jdk.java8.samples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 * 消费型接口Consumer<T>  void accept(T t)
 * 供给型接口Supplier<T>  T get()
 * 函数型接口Function<T,R> R appLy(T t)
 * 断定型接口Predicate<T> boolean test(T t)
 *
 * @Classname lambdaTest2
 * @Description TODO
 * @Date 2021/9/13 21:56
 * @Created by xjl
 */
public class lambdaTest2 {

    public static void main(String[] args) {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("好好学习");
            }
        });
        //采用的式lambda的表达式
        happyTime(400, momey -> System.out.println("好好学习+" + momey));
    }

    public static void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public static List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterlist = new ArrayList<>();
        for (String s : filterlist) {
            if (pre.test(s)) {
                filterlist.add(s);
            }
        }
        return filterlist;
    }
}
