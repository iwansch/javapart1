package com.telesens.academy.lesson02;

import java.util.Scanner;

public class HT7Reminder {

    public static void main(String[] args) {
        System.out.println("Input q");
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        System.out.println("Input w");
        int w = scanner.nextInt();
        int z = q/w;
        int r = q%w;
        System.out.println("q = " + q + ";");
        System.out.println("w = " + w + ";");
        System.out.println("q/w = " + z + ";");
        System.out.println("r = " + r + " (остаток)");
    }
}
