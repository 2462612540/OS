package com.xjl.jdk.java8.samples.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname StreamTest2
 * @Description 主要是测试stream的中间操作
 * @Date 2021/9/20 18:20
 * @Created by xjl
 */
public class StreamTest2 {

    @Test
    public void test1() {
        //filter(Predicate p)—接收Lambda ,从流中排除某些元素
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        //查询员工表中薪资大于601的员工信息
        stream.filter(e -> e.getSalary() > 600).forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        //Limit(n) 截断流，使其元素不超过给定数量。
        employees.stream().limit(1).forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        //skip(n)—跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回
        employees.stream().skip(7).forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        //distinct()—筛选，通过流所生成元素的hashCode()和equals()）去除重复元素
        employees.add(new Employee(1, "丫头1", 36, 605.38));
        employees.add(new Employee(1, "丫头1", 36, 605.38));
        employees.add(new Employee(1, "丫头1", 36, 607.38));
        employees.stream().distinct().forEach(System.out::println);
    }

    /**
     * @description 映射关系
     * @param:
     * @date: 2021/9/20 18:39
     * @return: void
     * @author: xjl
     */
    @Test
    public void test2() {
        //map(Function f)接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        //求解员工姓名长度大于2的员工
        nameStream.filter(name -> name.length() > 2).forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        //fLatMap(Function f)--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流合并成为一个流
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest2::fromStringtoStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("---------------------------------------------------------");
        Stream<Character> characterStream = list.stream().flatMap(StreamTest2::fromStringtoStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringtoStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character C : str.toCharArray()) {
            list.add(C);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        //sorted()—自然排序
        //sorted( comparator com)—定制排序
        List<Integer> list = Arrays.asList(12, 15, 18, 49, 57);
        list.stream().sorted().forEach(System.out::println);

        //拋异常，原因: Employee没有实现Comparable接a
        //List<Employee> employees = EmployeeData.getEmployees();
        //employees.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        //实现的是定时的排序方法
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            return Integer.compare(e1.getAge(), e2.getAge());
        }).forEach(System.out::println);

        //当比较大条件相同的时候 再一次选择其他的比较的条件
        employees.stream().sorted((e1, e2) -> {
            int value = Integer.compare(e1.getAge(), e2.getAge());
            if (value != 0) {
                return value;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }

        }).forEach(System.out::println);
    }
}
