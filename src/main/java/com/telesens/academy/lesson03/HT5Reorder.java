package com.telesens.academy.lesson03;

import java.util.Scanner;

public class HT5Reorder {
    public static void main(String[] args) {
        String consoleString = getStringFromConsole("Input String");// Получаем введенную строку
        String reversedString = reverseSymbolsInString(consoleString);// Перевернутую строку
        printConsoleString(consoleString);// Напечатать исходную строку
        printReversedString(reversedString);// Напечатать перевернутую строку
    }

    private static String getStringFromConsole(String line) {
        System.out.println(line);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String reverseSymbolsInString(String consoleString) {
        StringBuilder reversedString = new StringBuilder(consoleString.trim());
        reversedString = reversedString.reverse();
        //Метод toString представляет объекта в виде строки

        return reversedString.toString();
    }

    private static void printConsoleString(String consoleString) {
        System.out.println("Your string is: " +  consoleString);

    }

    private static void printReversedString(String reversedString) {
        System.out.println("Reversed string is: " +  reversedString);

    }
}
