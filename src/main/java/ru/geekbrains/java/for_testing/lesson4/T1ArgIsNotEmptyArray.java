package ru.geekbrains.java.for_testing.lesson4;

import java.util.Arrays;

/**
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
    Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

public class T1ArgIsNotEmptyArray {

    public static int[] ElementsAfterLastFour(int[] arr) throws RuntimeException {
        int n = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            if (n == -1) {
                throw new RuntimeException("В заданном массиве отсутствует \"4\"");
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            // -- попробовать через Arrays.copyOfRange(arr, n + 1, arr1.length);
            return arr1;
    }

}