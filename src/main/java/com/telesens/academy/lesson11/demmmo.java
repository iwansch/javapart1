package com.telesens.academy.lesson11;


import java.io.*;

public class demmmo {

        public static void main(String[] args) {

            try(FileWriter writer = new FileWriter("notes3.txt", false))
            {
                // запись всей строки
                String text = "Так, в конструктор передается либо путь к файлу в виде строки," +
                        " либо объект File, который ссылается на конкретный текстовый файл. " +
                        "Параметр append указывает, должны ли данные дозаписываться в конец " +
                        "файла (если параметр равен true), либо файл должен перезаписываться.\n" +
                        "\n" +
                        "Запишем в файл какой-нибудь текст:";
                writer.write(text);
                // запись по символам
                writer.append('\n');
                writer.append('E');

                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }