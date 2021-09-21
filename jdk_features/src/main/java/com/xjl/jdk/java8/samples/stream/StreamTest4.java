package com.xjl.jdk.java8.samples.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description 主要是测试stream的终止的操作的函数
 * @param: null
 * @date: 2021/9/20 19:19
 * @return:
 * @author: xjl
 */
public class StreamTest4 {
    //规约 归并处理
    @Test
    public void test1() {
        //reduce(T identity，Binaryoperator)—-可以将流中元素反复结合起来,
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //reduce(BinaryOperator) 一可以将流中元素反复结合起来,
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        //Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        Optional<Double> reduce2 = doubleStream.reduce((e1, e2) -> e1 + e2);
        System.out.println(reduce2);
    }

    //收集
    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 600).collect(Collectors.toList());
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 600).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        collect.forEach(System.out::println);
    }
}
