package com.dpf.bean;

import java.io.Serializable;

/**
 * @author dpf
 * @create 2020-01-14 12:31
 * @email 446933040@qq.com
 */
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
