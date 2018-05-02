package com.itasura.feature.stream;

import com.itasura.feature.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * 名    称：
 * 功    能：
 * 创 建 人：sailor
 * 创建时间：2018/4/28下午10:16
 * 修 改 人：
 * 修改时间：
 * 说    明：
 * 版 本 号：
 */
public class App {

    private static List<Person> list = new ArrayList();

    static{
        Person p1 = new Person();
        p1.setAge(16);
        p1.setName("zhangsan");
        Person p2 = new Person();
        p2.setAge(17);
        p2.setName("lisi");
        Person p3 = new Person();
        p3.setAge(18);
        p3.setName("wangwu");
        Person p4 = new Person();
        p4.setAge(19);
        p4.setName("zhangsan");
        Person p5 = new Person();
        p5.setAge(19);
        p5.setName("wangwu");
        Person p6 = new Person();
        p6.setAge(19);
        p6.setName("wangwu");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p6);

    }

    /**
     * 1.获取流
     * @return
     */
    public static void createStream(){
        List<Person> list = new ArrayList<Person>();
        Stream<Person> stream1 = list.stream();

        Stream<String> stream2 = Stream.of("zhangsan","lisi","wangwu");

        String[] names = {"zhangsan","lisi","wangwu"};
        Stream<String> stream3 = Arrays.stream(names);
    }

    /**
     * 筛选filter
     * @return
     */
    public static List<Person> findStudent(){
        List<Person> students = list.stream().filter(Person::isStudent).collect(toList());
        // 打印
        students.stream().forEach(System.out::print);
        return students;
    }

    /**
     * 去重distinct
     */
    public static void distinct(){
        System.out.println("-- before distinct --"+list);
        list = list.stream().distinct().collect(toList());
        System.out.println("-- after distinct --"+list);

    }

    /**
     * 截取
     */
    public static void limit(){
        System.out.println("-- before limit --"+list);
        list = list.stream().limit(3).collect(toList());
        System.out.println("-- after limit --"+list);
    }

    /**
     * 跳过
     */
    public static void skip(){
        System.out.println("-- before skip --"+list);
        list = list.stream().skip(3).collect(toList());
        System.out.println("-- after skip --"+list);
    }

    /**
     *  映射
     */
    public static void map(){
        List<String> result = list.stream().map(Person::getName).collect(toList());
        result.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        //findStudent();
        //distinct();
        //limit();
        //skip();
        map();
    }


}
