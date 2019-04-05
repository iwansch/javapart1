package com.telesens.academy.lesson08;

import com.telesens.academy.lesson08.ParseAbonentException;

import static com.telesens.academy.lesson04.AbonentDemo2.parseFirstName;

public class ExceptionDemo {
    public static void main(String[] args) {
        //String abonentRawString = "  heLen iVanova 35 f 0501234567";
        String abonentRawString = "";

        String name = null;
        try {
            name = parseFirstName(abonentRawString);
        } catch (ParseAbonentException e) {
            System.out.println("Empty row. Details: " + e);;
            System.exit(1);
        }
            catch (Exception e) {
                System.out.println("Unknown error. Details: " + e);;
                System.exit(1);
        }
        System.out.println(name);
    }
}
