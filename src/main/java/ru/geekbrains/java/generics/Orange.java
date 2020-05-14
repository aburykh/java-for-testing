package ru.geekbrains.java.generics;


public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit newInstance() {
        return new Orange();
    }
}