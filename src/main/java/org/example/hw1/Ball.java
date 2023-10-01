package org.example.hw1;

public class Ball extends SolidOfRevolution {

    private static final int EXPONENT = 3;

    public Ball(final double radius) {
        super(radius);
    }

    public double getVolume() {
        return Math.PI * Math.pow(radius, EXPONENT);
    }
}
