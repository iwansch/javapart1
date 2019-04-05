package com.telesens.academy.lesson11;

import java.util.Comparator;

public class ComparatorByLastFirstNameImpl implements Comparator<Subscriber> {

    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        if (o1.getLastName().equals(o2.getLastName()))
            return o1.getFirstName().compareTo(o2.getFirstName());
        else
            return o1.getLastName().compareTo(o2.getLastName());
    }
}