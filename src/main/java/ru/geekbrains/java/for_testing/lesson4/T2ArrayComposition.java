package ru.geekbrains.java.for_testing.lesson4;

/**
2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
        Написать набор тестов для этого метода (по 3-4 варианта входных данных).
        [ 1 1 1 4 4 1 4 4 ] -> true
        [ 1 1 1 1 1 1 ] -> false
        [ 4 4 4 4 ] -> false
        [ 1 4 4 1 1 4 3 ] -> false
 */

public class T2ArrayComposition {

    public static boolean CheckComposition(int[] arr) {
        boolean one = false,
                four = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) one = true;
            else if (arr[i] == 4) four = true;
            else return false;
        }
        return one && four;
    }

}