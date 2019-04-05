package com.telesens.academy.lesson04;

import java.util.Objects;

public class HT1Construktor {

    int n;

    public HT1Construktor(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "HT1Construktor{" +
                "n=" + n +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HT1Construktor that = (HT1Construktor) o;
        return n == that.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }

}
