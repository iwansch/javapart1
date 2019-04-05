package com.telesens.academy.lesson13;
import com.telesens.academy.lesson11.Gender;
import com.telesens.academy.lesson11.Subscriber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

import static com.telesens.academy.lesson11.SubscriberDemoHT.getRendomStringfromFile;

public class UtilsHT {
    private static String javaPartPropertiesPath; // путь к файлу настроек

    private static String maleFirstNamesPath; // путь к файлу мужских имен
    private static String maleLastNamesPath; // путь к файлу мужских фамилий
    private static String femaleFirstNamesPath; // путь к файлу женских имен
    private static String femaleLastNamesPath; // путь к файлу женских фамилий

    private static int ageFrom; // начальный возраст абонента
    private static int ageTo; // конечный возраст абонента

    private static int subscribersCount; // количество абонентов

    private static String JDBC_URL = "jdbc:mysql://localhost:3306/Abonent?user=root" +
            "&password=i07v08a04n&serverTimezone=UTC&useSSL=false";

    //================================================================================//

    public UtilsHT() {
        // Читаем пути к файлам
        Properties properties = new Properties();

        File file = new File("d:/myprojects/java-part/data/java-part.properties");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.load(fis);

                // Получаем путь к файлу настроек
                javaPartPropertiesPath = properties.getProperty("java-part.prop");

                // Получаем путь к файлу мужских имен
                maleFirstNamesPath = properties.getProperty("male.firstnames");
                // Получаем путь к файлу мужских фамилий
                maleLastNamesPath = properties.getProperty("male.lastnames");

                // Получаем путь к файлу женских имен
                femaleFirstNamesPath = properties.getProperty("female.firstnames");
                // Получаем путь к файлу женских фамилий
                femaleLastNamesPath = properties.getProperty("female.lastnames");

                // Получаем начальный возраст абонента
                ageFrom = Integer.parseInt(properties.getProperty("age.from"));
                // Получаем конечный возраст абонента
                ageTo = Integer.parseInt(properties.getProperty("age.to"));

                // Получаем количество Абонентов
                subscribersCount = Integer.parseInt(properties.getProperty("subscribers.count"));
            } catch (Exception e) {
//              e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } else
            System.out.println("Файл не существует!");
    }

    // Генерируем данные для Абонента
    public ArrayList<Subscriber> createAbonentData() {

        ArrayList<Subscriber> subscriberList = new ArrayList<>();

        for (Long i = 1L; i <= subscribersCount; i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(i);

            Random random = new Random();
            Gender[] genderArray = Gender.values();
            Gender gender = genderArray[random.nextInt(genderArray.length)];

            if (gender.toString().trim().toLowerCase().equals("м")) {
                subscriber.setFirstName(getRendomStringfromFile(maleFirstNamesPath));
                subscriber.setLastName(getRendomStringfromFile(maleLastNamesPath));
            } else {
                subscriber.setFirstName(getRendomStringfromFile(femaleFirstNamesPath));
                subscriber.setLastName(getRendomStringfromFile(femaleLastNamesPath));
            }

            subscriber.setGender(gender);

            int age = ageFrom + random.nextInt((ageTo - ageFrom) + 1);
            subscriber.setAge(age);

            Operator operator = new Operator();
            operator.setName(Operator.getOperatorName());
            operator.setId(Operator.getOperatorId(operator.getName()));

            //subscriber.setPhoneNumber(getOperatorPhoneNumber(operator.getName()));
            //subscriber.setOperator(operator);

            subscriberList.add(subscriber);
        }

        return subscriberList;
    }

    // Добавляем данные абонентов в таблицу abonent
    public void addSubscribersDataToAbonentTable() {
        try {
            // Получаем данные для Абонентов
            List<Subscriber> subscribers = this.createAbonentData();

            Connection connection = this.getConnection();

            // Автогенерация первичного ключа в таблице abonent
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO abonent(first_name, last_name, gender, age) VALUES(?, ?, ?, ?)");

            // Добавляем данные Абонентов в таблицу abonent
            for (Subscriber subscriber : subscribers) {
                preparedStatement.setString(1, subscriber.getFirstName());
                preparedStatement.setString(2, subscriber.getLastName());

                if (subscriber.getGender().equals(Gender.MALE))
                    preparedStatement.setString(3, "m");
                else
                    preparedStatement.setString(3, "f");

                preparedStatement.setInt(4, subscriber.getAge());

                preparedStatement.execute();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    // Наполняем таблицу phone_book
//    public void addDataToPhoneBookTable() {
//
//        // Берем свободные номера из таблицы operator_number
//        List<String> phoneOperatorNumbers = this.getFreePhoneOperatorNumbers();
//        List<Long> subscriberIds = new ArrayList<>();
//
//        Connection connection = this.getConnection();
//
//        try {
//            // Берем абонентов из таблицы abonent
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT abonent_id FROM abonent");
//            while (resultSet.next()) {
//                Long abonentId = resultSet.getLong("abonent_id");
//                subscriberIds.add(abonentId);
//            }
//
//            // Наполняем таблицу phone_book
//            Random randomPhoneOperator = new Random();
//            Random randomSubscriber = new Random();
//
//            // Телефонных номеров должно быть больше, чем абонентов,
//            // но на всякий случай делаем такое условие
//            while (phoneOperatorNumbers.size() != 0 && subscriberIds.size() != 0) {
//
//                String phoneNumber = phoneOperatorNumbers.get(randomPhoneOperator.nextInt(phoneOperatorNumbers.size()));
//                Long subscriberId = subscriberIds.get(randomSubscriber.nextInt(subscriberIds.size()));
//
//                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO phone_book(number, abonent_id) VALUES(?, ?)");
//                preparedStatement.setString(1, phoneNumber);
//                preparedStatement.setLong(2, subscriberId);
//
//                preparedStatement.execute();
//
//                phoneOperatorNumbers.remove(phoneNumber);
//                subscriberIds.remove(subscriberId);
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    // Инициализация драйвера
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
