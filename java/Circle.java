package circle;

public class Circle{
    private double radius;

    // Constructor
    public Circle(double radius){
        if (!isValidRadius(radius)){
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }
    
    // no-args Constructor
    public Circle(){
        this(1);
    }
    
    public void setRadius(double radius){
        if (!isValidRadius(radius)){
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }
    
    private boolean isValidRadius(double radius){
        return radius > 0;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double area(){
        return Math.PI * radius * radius;
    }
    
    public double perimeter(){
        return 2 * Math.PI * radius;
    }
    
    public double circumference(){
        return perimeter();
    }

    // Main App
    public static void main(String[] args){
        Circle c1 = new Circle();
        c1.setRadius(10.0);
            
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.area());
        System.out.println("Perimeter: " + c1.perimeter());
        System.out.println("Circumference: " + c1.circumference());        
    }
}