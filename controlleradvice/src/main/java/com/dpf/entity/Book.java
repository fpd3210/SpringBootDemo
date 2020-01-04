package com.dpf.entity;

/**
 * @author dpf
 * @create 2020-01-04 16:27
 * @email 446933040@qq.com
 */
public class Book {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
