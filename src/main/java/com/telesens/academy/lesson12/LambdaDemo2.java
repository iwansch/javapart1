package com.telesens.academy.lesson12;

import java.util.Scanner;

//Использование одного и того же функционального интерфейса
// с тремя различными лямбда-выражениями.
//Функциональный интерфейс принимает два параметра типа iпt и
//возвращает результат типа boolean.
 //iпterface NumericTest {boolean test(int n, int m);}
class LambdaDemo2 {
    public static void main(String args[]) {
        //Данное лямбда-выражение проверяет, кратно ли одно число другому
        NumericTest isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("2 является делителем 10");
        if (!isFactor.test(10, 3))
            System.out.println("З не является делителем 10");
        System.out.println();
////Данное лямбда-выражение возвращает true, если
////первый аргумент меньше второго
//      //  Исnоnьэуется один
        NumericTest lessThan = (n, m) -> (n < m);
       // --------+-и тот же интерфейс
        if (lessThan.test(2, 10)) System.out.println("2 меньше 10");
        if (!lessThan.test(10, 2)) System.out.println("10 не меньше 2");
        System.out.println();
////Данное лямбда-выражение возвращает true, если оба
////аргумента равны по абсолютной величине
        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
        if (absEqual.test(4, -4))
            System.out.println("Aбcoлютныe величины 4 и -4 равны");
        if (!lessThan.test(4, -5))
            System.out.println("Aбcoлютныe величины 4 и -5 не равны");
        System.out.println();

//        Создайте блочное лямбда-выражение для вычисления факториала целого числа.
//                Продемонстрируйте его использование
        NumericFunc factorial = (n) -> {
            int r = 1; for(int i = 1; i <=n; i++) { r = i * r; } return r;
        };

        for(int j = 17; j <= 17; j++) { //число не больше 33

            System.out.println(j + "! = " + factorial.func(j));
        }

//        Составьте лямбда-выражение, которое возвращает значение true, если
//        число принадлежит к диапазону чисел 10-20, включая граничные значения

        NumericRange range = (a, b, number) -> (number >= a && number <= b);

//        System.out.println("Input the number");
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        System.out.println();
        int number = 10;

            if (range.test(10, 20, number)) System.out.println("число " + number + " принадлежит диапазону 10 - 20");
            if (!range.test(10, 20, number)) System.out.println("число " + number + " не принадлежит диапазону 10 - 20");

    }
}