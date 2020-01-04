package com.dpf.entity;

import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author dpf
 * @create 2020-01-04 16:28
 * @email 446933040@qq.com
 */
public class Author {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
