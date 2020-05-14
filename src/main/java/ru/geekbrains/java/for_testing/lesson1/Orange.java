package ru.geekbrains.java.for_testing.lesson1;


public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit newInstance() {
        return new Orange();
    }
}