package com.telesens.academy.lesson03;
import java.util.ArrayList;
import java.util.Scanner;

public class HT1StartFromD {
    public static void main(String[] args)
    {
        String consoleText = inputYourText();
        printConsoleText(consoleText);
        printWordsD(consoleText);
    }
    private static String inputYourText() { // Считывание введенной строки
        System.out.println("Input Your Text");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine(); //nextLine(): считывает всю введенную строку
    }
    private static void printConsoleText(String consoleText) { // Вывод введенной строки
        System.out.println("Your text is: " + consoleText);
    }
    private static void printWordsD(String consoleText) { // Вывод слов на букву d
        int count = 0;   // количество слов на букву 'd'

        String[] strArray = consoleText.split(" ");
        ArrayList<String> words = new ArrayList<>();

        for (String str : strArray) {
            if (str.charAt(0) == 'd') {
                words.add(str);
                count++;
            }
        }
        System.out.println("Count = " + count);
        System.out.println("List words started from d:");

        for (String str : words)
            System.out.println(str);
    }
}