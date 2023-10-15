package org.example.hw3;

import java.util.List;

public class App {
public static void main(final String[] args) {
        final Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        final Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        final List<Apple> boxFruit = appleBox1.getBoxFruit();
        boxFruit.clear();

    }
}
