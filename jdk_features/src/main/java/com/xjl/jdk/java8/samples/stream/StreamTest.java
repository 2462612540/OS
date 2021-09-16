package com.xjl.jdk.java8.samples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "小焱1", 34, 600.38));
        list.add(new Employee(1002, "小焱2", 35, 601.38));
        list.add(new Employee(1003, "小焱3", 36, 602.38));
        return list;
    }
}

public class StreamTest {

    //通过集合的方式
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    //通过数组的方式
    public void test2() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(array);//返回的是一个流
    }

    //通过of的方式
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    //生成无线流
    public void test4() {
        //遍历前10日个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //遍历前10日个偶数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
