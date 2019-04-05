package com.telesens.academy.lesson03;

import javax.sound.sampled.Line;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HT3Substring {
    private static Object Line;

    public static void main(String[] args) {
        
        String consoleString = getStringFromConsole("Input String");
        String consoleSubString = getStringFromConsole("Input Substring");
        printConsoleString("Your String is: " + consoleString);
        consoleSubString("Your Substring is: " + consoleSubString);
        printCountSubstringInString(consoleSubString, consoleString);
    }

    private static void consoleSubString(String consoleSubString) {
        System.out.println(consoleSubString);
    }

    private static void printCountSubstringInString(String consoleSubString, String consoleString) {

        int count = 0;
        Pattern pattern = Pattern.compile(consoleSubString);
        Matcher matcher = pattern.matcher(consoleString);
                while (matcher.find())
                    count++;
        System.out.println("Number of substrings in the string = " + count);
    }

    private static void printConsoleString(String consoleString) {
        System.out.println(consoleString);

    }

    private static String getStringFromConsole(String line) {
        System.out.println(line);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
