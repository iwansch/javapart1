package com.telesens.academy.lesson11;

import java.util.Comparator;

public class ComparatorComplexImpl implements Comparator<Subscriber> {
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        if (o1.getOperator().getName().equals(o2.getOperator().getName())){
            return Integer.compare(o1.getAge(), o2.getAge());
        } else {
            return o2.getOperator().getName().compareTo(o1.getOperator().getName());
        }
    }
}