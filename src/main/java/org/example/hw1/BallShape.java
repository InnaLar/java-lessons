package org.example.hw1;

public class BallShape extends SolidOfRevolution {

    private static final int EXPONENT = 3;

    public BallShape(final double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, EXPONENT);
    }
}
