import java.util.ArrayList;
public class Box extends Shape{
    private ArrayList<Shape> box;
    public double getShapesVolume() {
        double boxVolume = 0;
        for (Shape shape:box
             ) {
            boxVolume+=shape.getVolume();
        }
        return boxVolume;
    }


    public boolean Add(Shape shape){
        if (box == null) box = new ArrayList<Shape>();
        if (this.getShapesVolume()+shape.getVolume()>this.getVolume())
            return false;
        else box.add(shape);
        return true;
    }
    public Box(double volume){
        this.volume = volume;
    }
}
