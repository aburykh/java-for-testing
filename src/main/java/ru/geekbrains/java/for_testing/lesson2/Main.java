package ru.geekbrains.java.for_testing.lesson2;

import java.io.FileNotFoundException;

/**
 * 1. Реализовать сохранение данных в csv файл;
 * 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
 * <p>
 * Структура csv файла:
 * //        Строка заголовок с набором столбцов
 * //        Набор строк с целочисленными значениями
 * //
 * //        * Разделитель между столбцами - символ точка с запятой (;)
 * <p>
 * Пример:
 * //        Value 1;Value 2;Value 3
 * //        100;200;123
 * //        300,400,500
 * <p>
 * Для хранения данных использовать класс вида:
 * //    public class AppData {
 * //        private String[] header;
 * //        private int[][] data;
 * //
 * //        // ...
 * //    }
 * <p>
 * Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        AppData appData = new AppData("test.csv");
        appData.testCsvReader("test.csv");
        System.out.println("\n>>> First reading is done!\n");

        appData.csvReader("test.csv");
        appData.printData();
        System.out.println("\n>>> Second reading & printing is done!");

        appData.csvWriter("test2.csv");
        System.out.println("\n>>> Recording is done!");

    }

}
