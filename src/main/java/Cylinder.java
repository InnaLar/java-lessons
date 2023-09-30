public class Cylinder extends SolidOfRevolution {
    private double height;

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI*Math.pow(getRadius(),2)*height;
    }

}
