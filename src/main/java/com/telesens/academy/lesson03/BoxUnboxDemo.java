package com.telesens.academy.lesson03;

public class BoxUnboxDemo {
    public static void main(String[] args) {
        int n = 5;
        Integer k = 6;
        k = n;
        n = k;

        int z1 = 250;
        int z2 = 250;
        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z1 == z2);

        Integer x1 = 250;
        Integer x2 = 250;
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x1.equals(x2));

    }
}
