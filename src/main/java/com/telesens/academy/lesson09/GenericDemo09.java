package com.telesens.academy.lesson09;

import javafx.util.Pair;

public class GenericDemo09 {

    public static void main(String[] args) {


        String[] arrString = {"1", "3", "5", "567", "007"};

        Integer[] arrInt = new Integer[arrString.length];

        for (int i = 0; i < arrString.length; i++) {
            arrInt[i] = Integer.valueOf(arrString[i]);
        }
        Object[] arrObj = new Object[arrInt.length];

        for (int i = 0; i < arrInt.length; i++) {
            arrObj[i] = arrInt[i];
        }
        Integer[] arrInt1 = new Integer[arrObj.length];

        for (int i = 0; i < arrString.length; i++) {
            arrInt1[i] = (Integer) arrObj[i];
            System.out.println(arrInt1[i]);
        }

    }
}