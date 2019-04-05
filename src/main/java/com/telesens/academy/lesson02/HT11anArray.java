package com.telesens.academy.lesson02;

public class HT11anArray {
    public static void main(String[] args)
    {
        int[] myArray = {3, 4, 9, 10, 34, 239, 8, 0, -3, 19, 17};
        //using for
        System.out.println("using 'for' cycle");
        System.out.print("[");
        for (int i = 0; i < myArray.length-1; i++)
        {
            System.out.print(myArray[i] + ", ");
        }
        int last = myArray[myArray.length-1];
        System.out.print(last);
        System.out.println("]");
        //using while
        System.out.println("using 'while' cycle");
        System.out.print("[");
        int i = 0;
        while ( i < myArray.length-1)
        {
            System.out.print(myArray[i] + ", "); i++;
        }
        //int last = myArray[myArray.length-1];
        System.out.print(last);
        System.out.print("]");
    }
}
