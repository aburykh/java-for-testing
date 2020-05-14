package ru.geekbrains.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку
 */

public class Box<T extends Fruit> {

    private List<T> fruitBox;

    public Box(T... arrFruits) {
        fruitBox = new ArrayList<T>(Arrays.asList(arrFruits));
    }


    public float boxWeight() {
        if (fruitBox.size() == 0)
            return 0.0f;
        else {
            return fruitBox.get(0).getWeight() * fruitBox.size();
        }
    }

//    public float boxWeight() {
//        float totalWeight = 0.0f;
//        for (T fruit : fruitBox) {
//            totalWeight += fruit.getFruitWeight();
//        }
//        return totalWeight;
//    }


    public void addFruits(T fruit) {
        fruitBox.add(fruit);
    }


    public boolean compare(Box otherBox) {
        return Math.abs(this.boxWeight() - otherBox.boxWeight()) < 0.001f;
    }


    public void transport(Box<T> otherBox) {
        if (this == otherBox)
            return;
        otherBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }
}