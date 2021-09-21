package com.xjl.jdk.java8.samples.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description 主要是测试stream的终止的操作的函数
 * @param: null
 * @date: 2021/9/20 19:19
 * @return:
 * @author: xjl
 */
public class StreamTest3 {

    //通过集合的方式
    @Test
    public void test1() {
        //allMatch(Predicate p)一检查是否匹配所有元素。
        List<Employee> employees = EmployeeData.getEmployees();
        //练习:是否所有的员工的年龄都大于18
        boolean result = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(result);

        //anyMatch(Predicate p)一检查是否至少匹配一个元素。练习:是否存在员工的工资大于1
        boolean result2 = employees.stream().anyMatch(e -> e.salary > 100);
        System.out.println(result2);
        // noneMatch(Predicate p)—检查是否没有匹配的元素。
        // 练习:是否存在员工姓"雷”
        boolean result3 = employees.stream().noneMatch(e -> e.getName().startsWith("庄"));
        System.out.println(result3);

        //findFirst—-返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny—返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        //count——-返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 600).count();
        System.out.println(count);

        //max( Comparator c)一返回流中最大值练习:返回最高的工资:
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);

        //min(Comparator c)一返回流中最小值练习:返回最低工资的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

        //forEach(Consumer c)一内部迭代

        employees.stream().forEach(System.out::println);
    }

}
