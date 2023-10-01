package org.example.hw1;

public class Pyramid implements IShape {
    private static final double ONE_THREE = 1.0 / 3.0;
    private final double height;
    private final double square;

    public Pyramid(final double height, final double square) {
        this.height = height;
        this.square = square;
    }

    public double getHeight() {
        return height;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public double getVolume() {
        return ONE_THREE * getHeight() * getSquare();
    }


}
