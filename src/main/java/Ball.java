public class Ball extends SolidOfRevolution{
    @Override
    public double getVolume() {
        return Math.PI*Math.pow(radius,3);
    }
}
