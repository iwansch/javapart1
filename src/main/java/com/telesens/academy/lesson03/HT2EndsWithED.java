package com.telesens.academy.lesson03;
import java.util.ArrayList;
import java.util.Scanner;

public class HT2EndsWithED {

    public static void main(String[] args) {

        String consoleText = inputYourText();
        printConsoleText(consoleText);
        printWordsED(consoleText);
    }
    private static String inputYourText() { // Считывание введенной строки
        System.out.println("Input Your Text");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine(); //nextLine(): считывает всю введенную строку
    }
    private static void printConsoleText(String consoleText) { // Вывод введенной строки

        System.out.println("Your text is: " + consoleText);
    }
    private static void printWordsED(String consoleText) { // Вывод слов с окончанием ED
        int count = 0;   // количество таких слов

        String[] strArray = consoleText.split("");
        ArrayList<String> words = new ArrayList<>();

        for (String str : strArray) {
            String result = str.substring(str.length() - 2);

            if (result.equals("ED")) {
                words.add(str);
                count++;
            }
        }
        System.out.println("Count = " + count);
        System.out.println("List words ended with ED:");

        for (String str : words)
            System.out.println(str);
    }
}

