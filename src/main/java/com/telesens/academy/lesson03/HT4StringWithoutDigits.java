package com.telesens.academy.lesson03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HT4StringWithoutDigits {

    private static StringBuilder removedSymbols = new StringBuilder();// Список удаленных символов

    public static void main(String[] args) {
        String consoleString = getStringFromConsole("Input String");//получить строку
        String stringAfterTransformation = removeAllDigits(consoleString);//удалить цифры и преобразовать
        printConsoleString(consoleString);//напечатать введенную строку
        printStringAfterTransformation(stringAfterTransformation);//напечатать преобразованную строку
        printRemovedSymbolsFromInputString();//напечатать удаленные символы
    }

    private static String getStringFromConsole(String line) {
        System.out.println(line);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String removeAllDigits(String consoleString) {
        Pattern pattern = Pattern.compile("\\d");
        //создать объект Pattern с помощью статического метода compile(),
        // который позволяет установить шаблон
        Matcher matcher = pattern.matcher(consoleString);
        //для поиска соответствий применяется класс Matcher
        // метод matcher(String input) в качестве параметра принимает строку,
        // где надо проводить поиск, и возвращает объект Matcher
        while (matcher.find())
        // метод find() класса Matcher позволяет переходить к следующему совпадению в строке
            removedSymbols.append(matcher.group());
        // Параметр append указывает должны ли данные дозаписываться либо перезаписываться
        // Каждое совпадение получаем с помощью метода matcher.group()

        String stringAfterTransformation = consoleString.replaceAll("\\d", "");
        return stringAfterTransformation;
    }

    private static void printConsoleString(String consoleString) {
        System.out.println("Your string is: " +  consoleString);

    }

    private static void printStringAfterTransformation(String stringAfterTransformation) {
        System.out.println("Transformed string is: " + stringAfterTransformation);

    }

    private static void printRemovedSymbolsFromInputString() {
        System.out.println("Removed symbols are: " + removedSymbols);

    }

}
