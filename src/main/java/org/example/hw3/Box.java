package org.example.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> boxFruit = new ArrayList<>();

    public void add(final T fruit) {
        boxFruit.add(fruit);
    }

    public List<T> getBoxFruit() {
        return Collections.unmodifiableList(boxFruit);
    }

    public float getWeight() {
        float sumWeightFruits = 0;
        for (T fruit : boxFruit) {
            sumWeightFruits += fruit.getWeight();
        }
        return sumWeightFruits;
    }

    public boolean compareWeight(final Box<?> another) {
        return Float.compare(this.getWeight(), another.getWeight()) == 0;
    }

    public void addWholeBox(final Box<T> another) {
        boxFruit.addAll(another.boxFruit);
        another.boxFruit.clear();
    }
}
