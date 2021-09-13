package com.xjl.jdk.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Classname Lambada
 * 举例子： （01，o2）->Integer.compare(o1,o2)
 * 格式：
 * lambda 操作符号 箭头符号
 * 左边是lambda的形参列表
 * 右边是lambda的重写的抽象方法的方法体
 * <p>
 * lmbada的本质作为接口的实例
 * @Description
 * @Date 2021/9/13 20:36
 * @Created by xjl
 */
public class Lambada {

    //语法格式一:无参，无返回值
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是庄晓燕");
            }
        };

        r1.run();
        System.out.println("**********新的Lambda表达式************");
        Runnable r2 = () -> System.out.println("我是庄晓燕2");
        r2.run();

    }

    //语法格式二: Ldmbda需妻一个参数，但是没有返回值。
    public void test2() {
        Consumer<String> com = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        com.accept("谎言和誓言的区别是什么");

        Consumer<String> con = (String s) -> {
            System.out.println(s);
        };
        con.accept("-个是听得人当真了，一个是说的人当真了");
    }

    //语法格式三:数据类型可以省略，因为可由编译器推断得出，称为"类型推断”
    public void test3() {
        Consumer<String> com = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        com.accept("谎言和誓言的区别是什么");
        //删除了空号中Stringd的表示
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("-个是听得人当真了，一个是说的人当真了");
    }

    //语法格式Lambda若只需要一个参数时，参数的小括号可以省略
    public void test4() {

        Consumer<String> con = s -> {
            System.out.println(s);
        };
        con.accept("-个是听得人当真了，一个是说的人当真了");
    }

    //语法格式Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    public void test5() {

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        com1.compare(87, 90);
        System.out.println("___________________________");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        com2.compare(67, 70);
    }


    //语法格式当Lambda 体只有一条语句时，return与大括号若有，都可以省略
    public void test6() {
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        com2.compare(67, 70);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
        //JDK8推荐写法
        Collections.sort(names2, (String a, String b) -> {
            return b.compareTo(a);
        });
        //JDk8的lambda表达式的简单写法
        names2.sort((a, b) -> b.compareTo(a));

        for (String s : names2) {
            System.out.println(s);
        }
        System.out.println("*******************************************");
        Runnable runnable = () -> System.out.println("我是庄小焱");

        runnable.run();

        System.out.println("*******************************************");
        //方法的引用
        Comparator<Integer> com = Integer::compare;
        int compare3 = com.compare(32, 21);
        System.out.println(compare3);
    }
}
