public class Pyramid extends Shape{
    private double height;
    private double square;

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public double getVolume() {
        return (double)(1/3)*getHeight()*getSquare();
    }



}
