package ru.geekbrains.java.for_testing.lesson5;

public class TempApp {
    public static void main(String[] args) {
        int min = 97;
        int max = 122;
        for (int i = 1; i < 2000; i++) {
            char symbol = (char)(97 + (int)(Math.random() * 26));
            System.out.print((char)symbol);
        }
    }
}
