package com.dehghan.arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    /*    int[] numbers = new int[3];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        //int[] numbers = {10, 20,30};
        System.out.println(numbers.length);
        System.out.println(Arrays.toString(numbers));
       // System.out.println(numbers);
*/
        ////////////////////////
        Array num = new Array(3);
        num.insert(10);
        num.insert(20);
        num.insert(30);
        num.insert(40);
        num.removeAt(1);
        num.indexOf(100);
        System.out.println(num.indexOf(30));
        num.print();
    }
}
