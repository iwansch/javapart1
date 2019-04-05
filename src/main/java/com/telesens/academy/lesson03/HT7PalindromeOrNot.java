package com.telesens.academy.lesson03;

import java.util.Scanner;

public class HT7PalindromeOrNot {
    public static void main(String[] args) {

    String consoleString = getStringFromConsole(); // Получаем введенную строку
    determinePalindromeString(consoleString);// Определяем палиндром или нет
    }
    private static String getStringFromConsole() {
        System.out.println("Input String");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static void determinePalindromeString(String consoleString) {
        StringBuilder palindromeString = new StringBuilder(consoleString);
        System.out.println();

        if(palindromeString.reverse().toString().equals(consoleString))
            System.out.println("Your string is a Palindrome!");
        else
            System.out.println("Your string is not a Palindrome!");
    }
}
