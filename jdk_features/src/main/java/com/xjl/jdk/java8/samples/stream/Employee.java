package com.xjl.jdk.java8.samples.stream;

import lombok.Data;

/**
 * @Classname StreamTest
 * @Description TODO
 * stream关注的是对数据的运算，与CPU打交道集合关注的是数据的存储，与内存打交道
 * stream自己不会存储元素。
 * Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * Stream执行流程
 * Stream的实例化
 * 一系列的中间操作（过滤、映射、...)
 * 终止操作
 * 说明:
 * 1一个中间操作链，对数据源的数据进行处理
 * 2一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 * @Date 2021/9/16 23:49
 * @Created by xjl
 */
@Data
class Employee {
    int id;
    String name;
    int age;
    double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

}
