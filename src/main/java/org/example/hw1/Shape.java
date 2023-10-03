package org.example.hw1;

public interface Shape extends Comparable<Shape> {

    double getVolume();

    @Override
    default int compareTo(final Shape o) {
        final int d = (int) Math.round(this.getVolume() - o.getVolume());
        return (int) Math.signum(d);
    }
}
