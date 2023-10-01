package org.example.hw1;

public class Cylinder extends SolidOfRevolution {
    private final double height;

    public Cylinder(final double radius, final double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

}
