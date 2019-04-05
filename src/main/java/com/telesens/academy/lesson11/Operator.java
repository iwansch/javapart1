package com.telesens.academy.lesson11;

public class Operator {
    private long id;
    private static String name;


    public void setId(long id) {
        this.id = id;
    }


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}