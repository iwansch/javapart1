package com.telesens.academy.lesson02;

import java.util.Scanner;

public class HT13Triangle01
{
    public static void main(String[] args)
    {
        System.out.println("Input the triangle side");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        //int x = 6; заданная в программе сторона
        for (int i = x; i >= 1; i--)
        {
            for (int j = i; j <= x; j++)
            {
                System.out.print("*");
            }
            System.out.println("  ");
        }
    }
}
