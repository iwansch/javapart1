package com.telesens.academy.lesson10.HomeTask10;

/*

1) Дан массив имен: {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max}
	a) Создать список List из элементов массива и вывести на экран
	b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
	c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
	d) Поменять имя Helen на Elizabet
	e) Отсортировать имена по алфавиту и вывести на экран
	f) Отсортировать имена в обратном порядке и вывести имена на экран
	g) Перевести все первые символы в верхний регистр
	h) Вывести все имена, начинающиеся на букву A
	i) Проверить, содержит ли список имя Andry
	j) Удалить из списка все имена кроме Kate и Helen

*/

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        // Создать список List из элементов массива и вывести на экран
        System.out.println("Создать список List из элементов массива и вывести на экран");

//      String[] namesArray = new String[]{"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max" };
        String[] namesArray = new String[]{"peter", "helen", "andry", "abdel", "kate", "veronica", "leonid", "alex", "max"};
        List<String> namesList = new ArrayList<>(Arrays.asList(namesArray));

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Добавить 3 новых имени в список ('Philip', 'Joseph', 'Leon') и вывести весь список на экран
        System.out.println("Добавить 3 новых имени в список ('Philip', 'Joseph', 'Leon') и вывести весь список на экран");

        namesList.add("Philip");
        namesList.add("Joseph");
        namesList.add("Leon");

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Удалить из списка все имена: 'Veronica', 'Leonid' и вывести весь список на экран
        System.out.println("Удалить из списка все имена: 'Veronica', 'Leonid' и вывести весь список на экран");

        Collection<String> removeNames = new ArrayList<>(Arrays.asList("Veronica", "Leonid"));
        namesList.removeAll(removeNames);

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Поменять имя 'Helen' на 'Elizabet'
        System.out.println("Поменять имя 'Helen' на 'Elizabet'");

        if (namesList.contains("Helen")) {
            int index = namesList.indexOf("Helen");
            namesList.set(index, "Elizabet");
        }

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Отсортировать имена по алфавиту и вывести на экран
        System.out.println("Отсортировать имена по алфавиту и вывести на экран");
        namesList.sort(new Comparator<String>() {
            public int compare(String string1, String string2) {
                return string1.toLowerCase().compareTo(string2.toLowerCase());
            }
        });

/*
        Collections.sort(namesList, new Comparator<String>() {
            public int compare(String string1, String string2) {
                return string1.toLowerCase().compareTo(string2.toLowerCase());
            }
        });
*/

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Отсортировать имена в обратном порядке и вывести имена на экран
        System.out.println("Отсортировать имена в обратном порядке и вывести имена на экран");

        Collections.reverse(namesList);
        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Перевести все первые символы в верхний регистр
        System.out.println("Перевести все первые символы в верхний регистр");

        for (int i = 0; i < namesList.size(); i++) {
/*
            // 1-й способ
            String nameString = namesList.get(i).trim();
            StringBuilder nameStringBuilder = new StringBuilder(nameString);
            char firstLetterChar = namesList.get(i).trim().charAt(0);
            String firstLetterString = String.valueOf(firstLetterChar).toUpperCase();
            nameStringBuilder.setCharAt(0, firstLetterString.charAt(0));
            String resultString = nameStringBuilder.toString();
            namesList.set(i, resultString);
*/

            // 2-й способ
            char[] letters = namesList.get(i).trim().toCharArray();
            String firstLetter = String.valueOf(letters[0]).toUpperCase();
            letters[0] = firstLetter.charAt(0);
            String resultString = String.valueOf(letters);
            namesList.set(i, resultString);

/*
            // 3-й способ
            String nameString = namesList.get(i).trim();
            char firstLetterChar = namesList.get(i).trim().charAt(0);
            String firstLetterString = String.valueOf(firstLetterChar).toUpperCase();
            String nameStringWithoutFirstLetter = nameString.substring(1);
            String resultString = firstLetterString + nameStringWithoutFirstLetter;
            namesList.set(i, resultString);
*/

        }

        printArray(namesList);

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Вывести все имена, начинающиеся на букву 'A'
        System.out.println("Вывести все имена, начинающиеся на букву 'A'");

        for (String name : namesList) {
            if (name.trim().toLowerCase().startsWith("a"))
                System.out.println(name);
        }

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Проверить, содержит ли список имя 'Andry'
        System.out.println("Проверить, содержит ли список имя 'Andry'");

        if (namesList.contains("Andry"))
            System.out.println("List contains name 'Andry'");
        else
            System.out.println("List doesn't contain name 'Andry'");

        System.out.println();
        System.out.println("//--------------------------------------------------//");
        System.out.println();

        // Удалить из списка все имена, кроме 'Kate' и 'Helen'
        System.out.println("Удалить из списка все имена, кроме 'Kate' и 'Helen'");

        Collection<String> stayNames = new ArrayList<>(Arrays.asList("Kate", "Helen"));
        namesList.retainAll(stayNames);
        printArray(namesList);
    }

    //================================================================================//

    // Вывод массива в консоль
    private static void printArray(List<String> list) {
        for (String name : list) {
            System.out.println(name);
        }
    }
}
