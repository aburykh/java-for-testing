package ru.geekbrains.java.for_testing;

/**
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку
 */

public class Lesson1 {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruits(new Orange());
        orangeBox.addFruits(new Orange());

        appleBox.addFruits(new Apple());
        appleBox.addFruits(new Apple());
        System.out.println("appleBox weight is: " + appleBox.boxWeight());

        appleBox2.addFruits(new Apple());
        System.out.println("appleBox2 weight is: " + appleBox2.boxWeight());

        appleBox.transport(appleBox2);
        System.out.println("appleBox weight is: " + appleBox.boxWeight());
        System.out.println("appleBox2 weight is: " + appleBox2.boxWeight());

        System.out.println("Compare orangeBox and appleBox: " + appleBox.compare(orangeBox));
        System.out.println("Compare orangeBox and appleBox2: " + appleBox2.compare(orangeBox));
    }

}
