package com.telesens.academy.lesson05.HomeTask;

import com.telesens.academy.lesson05.exc.DateTime;

public class ExtendedTime extends DateTime {

    private int milliseconds;

    public ExtendedTime(int day, int month, int year, int hour,
                        int minute, int second, int milliseconds) {
        super(day, month, year, hour, minute, second);
        this.milliseconds = milliseconds;
    }

    @Override
    public String toString() {
        String dateFormat = super.toString();
        String extendedTimeFormat = String.format(".%03d", milliseconds);
        return dateFormat + extendedTimeFormat;
    }
}
