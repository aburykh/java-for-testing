package ru.geekbrains.java.generics;


public abstract class Fruit {

    protected float fruitWeight;

    public abstract Fruit newInstance();

    public float getFruitWeight() {
        return fruitWeight;
    }

    public Fruit(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }
}
