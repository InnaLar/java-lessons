package org.example.hw1;

public interface IShape extends Comparable<IShape> {

    double getVolume();

    @Override
    default int compareTo(IShape o) {
        int d = (int) Math.round(this.getVolume() - o.getVolume());
        return (int) Math.signum(d);
    }
}
