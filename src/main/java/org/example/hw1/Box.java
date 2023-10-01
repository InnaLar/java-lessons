package org.example.hw1;

import java.util.ArrayList;
import java.util.List;

public class Box implements IShape {
    private final double volume;
    private final List<IShape> iShapeList;

    public Box(final double volume) {
        this.iShapeList = new ArrayList<>();
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public double getShapesVolume() {
        double boxVolume = 0;
        for (IShape shape : iShapeList) {
            boxVolume += shape.getVolume();
        }
        return boxVolume;
    }

    public boolean add(final IShape shape) {
        if (this.getShapesVolume() + shape.getVolume() > this.getVolume()) {
            return false;
        }
        iShapeList.add(shape);
        return true;
    }
}
