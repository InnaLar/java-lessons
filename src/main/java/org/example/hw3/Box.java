package org.example.hw3;
import java.util.List;
import java.util.ArrayList;

public class Box <T extends Fruit>{
    private final float delta = 0.0001f;
    private List<T> boxFruit;
    public Box(){
        boxFruit = new ArrayList<T>();
    }
    public void add(T fruit){
        boxFruit.add(fruit);
    }
    public float getWeight(){
        float sumWeightFruits = 0;
        for (T fruit:boxFruit
             ) {
            sumWeightFruits+=fruit.getWeight();
        }
        return sumWeightFruits;
    }
    public boolean compareWeight(Box<?> another){
        return Math.abs(this.getWeight()-another.getWeight())<delta;
    }
    public void addWholeBox(Box<T> another){
        boxFruit.addAll(another.boxFruit);
        another.boxFruit = null;
        }
    }
