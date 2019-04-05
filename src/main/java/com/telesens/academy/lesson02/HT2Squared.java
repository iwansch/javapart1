package com.telesens.academy.lesson02;

import java.util.Scanner;

public class HT2Squared {
    public static void main(String[] args) {
        System.out.println("Input the number");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        System.out.println(count);
        //double x = Math.sqrt(count); корень квадратный
        double x = Math.pow(count, 2);
        System.out.println("Число " + count + " в квдрате = " + x);
    }
}
