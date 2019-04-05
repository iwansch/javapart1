package com.telesens.academy.lesson11;

import java.util.Comparator;

public class ComparatorByLastLetter implements Comparator<String> {
    @Override
    public int compare(String o1, String o2){
        String s1 = o1.trim().substring(o1.trim().length() - 1);
        String s2 = o2.trim().substring(o2.trim().length() - 1);

        return s1.compareTo(s2);
    }
}