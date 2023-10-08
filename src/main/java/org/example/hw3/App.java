package org.example.hw3;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        appleBox1.add(new Apple());

        List<Apple> boxFruit = appleBox1.getBoxFruit();
        boxFruit.clear();

    }
}
