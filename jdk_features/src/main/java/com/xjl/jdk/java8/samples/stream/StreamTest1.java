package com.xjl.jdk.java8.samples.stream;

import org.junit.Test;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

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
        Employee e1 = new Employee(101, "xiaoge", 62, 369.2);
        Employee e2 = new Employee(101, "xiaoying", 62, 369.2);
        Employee[] arr = new Employee[]{e1, e2};
        IntStream stream1 = Arrays.stream(array);//这里返回的是自定义类型的数组

    }

    //通过of的方式
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    //生成无线流
    @Test
    public void test4() {
        //遍历前10日个偶数 无线流的一种形式
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //遍历前10日个偶数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
