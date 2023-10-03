package org.example.hw1;

import java.util.ArrayList;
import java.util.List;

public class BoxShape implements Shape {
    private final double volume;
    private final List<Shape> shapeList;

    public BoxShape(final double volume) {
        this.shapeList = new ArrayList<>();
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public double getShapesVolume() {
        double boxVolume = 0;
        for (final Shape shape : shapeList) {
            boxVolume += shape.getVolume();
        }
        return boxVolume;
    }

    public boolean add(final Shape shape) {
        if (this.getShapesVolume() + shape.getVolume() > this.getVolume()) {
            return false;
        }
        shapeList.add(shape);
        return true;
    }
}
