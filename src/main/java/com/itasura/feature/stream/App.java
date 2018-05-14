package com.itasura.feature.stream;

import com.itasura.feature.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
    @Test
    public void createStream(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        // 返回一个顺序流
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = Stream.of("zhangsan","lisi","wangwu");
        String[] names = {"zhangsan","lisi","wangwu"};
        //由数组创建流
        Stream<String> stream3 = Arrays.stream(names);
        stream3.forEach(System.out::println);
        System.out.println("=========我是华丽分割线===========");
        // 返回一个并行流
        Stream<String> stream = list.parallelStream();
        stream.forEach(System.out::println);

    }

    /**
     * 筛选filter
     * @return
     */
    @Test
    public void findStudent(){
        List<Person> students = list.stream().filter(Person::isStudent).collect(toList());
        // 打印
        students.stream().forEach(System.out::print);
    }

    /**
     * 去重distinct
     */
    @Test
    public void distinct(){
        System.out.println("-- before distinct --"+list);
        list = list.stream().distinct().collect(toList());
        System.out.println("-- after distinct --"+list);

    }

    /**
     * 截取
     */
    @Test
    public void limit(){
        System.out.println("-- before limit --"+list);
        list = list.stream().limit(3).collect(toList());
        System.out.println("-- after limit --"+list);
    }

    /**
     * 跳过
     */
    @Test
    public void skip(){
        System.out.println("-- before skip --"+list);
        list = list.stream().skip(3).collect(toList());
        System.out.println("-- after skip --"+list);
    }

    /**
     *  映射
     */
    @Test
    public void map(){
        List<String> result = list.stream().map(Person::getName).collect(toList());
        result.stream().forEach(System.out::println);
    }

    /**
     * 匹配任一元素
     */
    @Test
    public void anyMatch(){
        Boolean flag = list.stream().anyMatch(Person::isStudent);
        System.out.println(flag);
    }

    /**
     * 匹配所有元素
     */
    @Test
    public void allMatch(){
        Boolean flag = list.stream().allMatch(Person::isStudent);
        System.out.println(flag);
    }

    /**
     * noneMatch与allMatch恰恰相反,它用于判断流中的所有元素是否都不满足指定条件
     */
    @Test
    public void noneMatch(){
        Boolean flag = list.stream().noneMatch(Person::isStudent);
        System.out.println(flag);
    }

    /**
     * findAny能够从流中随便选一个元素出来，它返回一个Optional类型的元素，实际返回的是第一个元素
     */
    @Test
    public void findAny(){
        System.out.println("findAny:"+list.stream().findAny().get());
        System.out.println("findFirst:"+list.stream().findFirst().get());
    }

    /**
     * 将流中元素反复结合起来，得到一个值
     */
    @Test
    public void reduce(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }



}
