package org.example.hw1;

public abstract class SolidOfRevolution implements IShape {
    protected final double radius;

    protected SolidOfRevolution(final double radius) {
        this.radius = radius;
    }
}
