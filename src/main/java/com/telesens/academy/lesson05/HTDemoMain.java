package com.telesens.academy.lesson05;

import com.telesens.academy.lesson05.HomeTask.ExtendedTime;

public class HTDemoMain {

    public static void main(String[] args) {

        System.out.println("Home task lesson 05");
        ExtendedTime dateTimeCurrent = new ExtendedTime(11, 2,
                2019, 20, 45, 0, 456);
        System.out.println(dateTimeCurrent); // 11/02/2019 20:45:00

        assert dateTimeCurrent.toString().equals("11/02/2019 20:45:00.456");
    }
}
