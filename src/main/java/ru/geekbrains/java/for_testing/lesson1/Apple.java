package ru.geekbrains.java.for_testing.lesson1;


public class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }

    @Override
    public Fruit newInstance() {
        return new Apple();
    }
}