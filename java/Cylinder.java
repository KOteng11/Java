package cylinder;

import circle.Circle;

public class Cylinder extends Circle{
    private double height;
    
    
    public void setHeight(double height){
        if (height <= 0){
            throw new IllegalArgumentException("height must be greater than 0.");
        }
        this.height = height;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double volume(){
        return area() * height;
    }
    
}