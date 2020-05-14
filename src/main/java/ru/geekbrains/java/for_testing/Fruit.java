package ru.geekbrains.java.for_testing;


public abstract class Fruit {

    protected float weight;

    public abstract Fruit newInstance();

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}
