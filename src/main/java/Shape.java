public abstract class Shape implements IShape{
    double volume;

    public double getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Shape o) {
        int d = (int) Math.round(this.getVolume()-o.getVolume());
        return (int) Math.signum(d);
    }
}
