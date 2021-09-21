package com.xjl.jdk.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EmployeeData
 * @Description TODO
 * @Date 2021/9/20 18:24
 * @Created by xjl
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "小焱1", 34, 600.38));
        list.add(new Employee(1002, "小焱2", 35, 601.38));
        list.add(new Employee(1003, "小焱3", 36, 602.38));
        list.add(new Employee(1004, "小焱4", 36, 603.38));
        list.add(new Employee(1005, "小焱5", 36, 604.38));
        list.add(new Employee(1006, "小焱6", 36, 605.38));
        list.add(new Employee(1007, "小焱7", 36, 606.38));
        list.add(new Employee(1008, "小焱8", 36, 607.38));
        return list;
    }
}
