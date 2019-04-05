package com.telesens.academy.lesson05.exc;

public class DateTime extends Date{
    private int hour;
    private int minute;
    private int second;

    public DateTime() {
    }

    public DateTime(int day, int month, int year, int hour, int minute, int second) {
        super(day, month, year); // Конструктор базового класса
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        String dateFormat = super.toString();
        String timeFormat = String.format("%02d:%02d:%02d", hour, minute, second);
        return dateFormat + " " + timeFormat;
//        return super.toString() + " " + String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // withXXX
    public DateTime withMinute(int minute) {
        this.minute = minute;
        return this;
    }

    public DateTime withSecond(int second) {
        this.second = second;
        return this;
    }

    public DateTime withHour(int hour) {
        this.hour = hour;
        return this;
    }
}
