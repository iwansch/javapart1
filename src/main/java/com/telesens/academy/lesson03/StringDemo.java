package com.telesens.academy.lesson03;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Demo";
        String str2 = new String("Dem" + "o");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1.equals(str2)); // true/false?
    }
}
