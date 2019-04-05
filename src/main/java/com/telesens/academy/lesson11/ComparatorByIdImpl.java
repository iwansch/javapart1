package com.telesens.academy.lesson11;

import java.util.Comparator;

public class ComparatorByIdImpl implements Comparator <Subscriber> {

    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
