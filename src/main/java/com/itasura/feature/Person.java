package com.itasura.feature;

/**
 * 名    称：
 * 功    能：
 * 创 建 人：sailor
 * 创建时间：2018/4/28下午10:15
 * 修 改 人：
 * 修改时间：
 * 说    明：
 * 版 本 号：
 */
public class Person {
    private Integer age;
    private String name;

    public Boolean isStudent(){
        return age <= 18;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
