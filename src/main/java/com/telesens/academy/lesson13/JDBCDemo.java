package com.telesens.academy.lesson13;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {



        System.out.println("JDBC");
        try {
// Инициализация драйвера
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Abonent?user=root" +
                            "&password=i07v08a04n&serverTimezone=UTC&useSSL=false");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO abonent(first_name, last_name, gender, age) VALUES(?, ?, ?, ?)");
            preparedStatement.setLong(1, 4L);
            preparedStatement.setString(2, "Наталья");
            preparedStatement.setString(3, "Ильинская");
            preparedStatement.setString(4, "f");
//            preparedStatement.setInt(5, 27);
//            preparedStatement.execute();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM abonent");


            UtilsHT utils = new UtilsHT();
            utils.addSubscribersDataToAbonentTable();


            while (resultSet.next()) {
                long id = resultSet.getLong("abonent_id");
                String firstName = resultSet.getString("first_name");
                System.out.println(String.format("ID = %d, First Name = %s",
                        id, firstName));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}