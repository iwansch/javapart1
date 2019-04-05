package com.telesens.academy.lesson13;

import com.telesens.academy.lesson11.Gender;
import com.telesens.academy.lesson11.Subscriber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JDBCHT {

    private static final int COUNT_SUBSCRIBERS = 200;
    private static final String MAN_FIRST_NAMES_PATH = "/Users/ivan/Downloads/task/java-part/data/maleFirstNames.txt";
    private static final String WOMAN_FIRST_NAMES_PATH = "/Users/ivan/Downloads/task/java-part/data/femaleFirstNames.txt";
    private static final String MAN_LAST_NAMES_PATH = "/Users/ivan/Downloads/task/java-part/data/maleLastNames.txt";
    private static final String WOMAN_LAST_NAMES_PATH = "/Users/ivan/Downloads/task/java-part/data/femaleLastNames.txt";

    private static List<String> maleFirstNames = new ArrayList<>();
    private static List<String> femaleFirstNames = new ArrayList<>();
    private static List<String> maleLastNames = new ArrayList<>();
    private static List<String> femaleLastNames = new ArrayList<>();

    public static void main(String[] args) {

        // подготавливаем данные

        maleFirstNames = prepareData(MAN_FIRST_NAMES_PATH);
        femaleFirstNames = prepareData(WOMAN_FIRST_NAMES_PATH);
        maleLastNames = prepareData(MAN_LAST_NAMES_PATH);
        femaleLastNames = prepareData(WOMAN_LAST_NAMES_PATH);

        Random random = new Random();

        for (int n = 1; n <=COUNT_SUBSCRIBERS; n++) {

        Subscriber subscriber = generateNextSubscriber(random);
        insertSubscriberToDB(subscriber);
        }
    }

    private static List<String> prepareData(String path) {

        List<String> result = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new FileReader(path))) {
            String row;
            while ((row = bfr.readLine()) != null) {
                result.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    // TODO
    private static void insertSubscriberToDB(Subscriber subscriber) {

        System.out.println(subscriber);

    }

    private static Subscriber generateNextSubscriber(Random random) {

        Subscriber subscriber = new Subscriber();

        //наполняем
        String firstName;
        String lastName;
        int nextIndex;
        if (random.nextBoolean()) {
// допустим мужчина
            nextIndex = random.nextInt(maleFirstNames.size());
            firstName = maleFirstNames.get(nextIndex);
            nextIndex = random.nextInt(maleLastNames.size());
            lastName = maleLastNames.get(nextIndex);
            subscriber.setGender(Gender.MALE);

        } else {
            // женщина
            nextIndex = random.nextInt(femaleFirstNames.size());
            firstName = femaleFirstNames.get(nextIndex);
            nextIndex = random.nextInt(femaleLastNames.size());
            lastName = femaleLastNames.get(nextIndex);
            subscriber.setGender(Gender.FEMALE);
        }
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        // ?? Гауссово
        subscriber.setAge(random.nextInt(86)+5);
        return subscriber;
    }
}
