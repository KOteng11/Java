public class Shapes
{
	public static void main(String[] args)
	{
		double squareArea = getArea(10.0, 15.0);
		double circleArea = getArea(5.0);
		
		System.out.println("Area of the square is: " + squareArea);
		System.out.println("Area of the circle is: " + circleArea);
	}
	
	public static double getArea(double l, double w)
	{
		return l * w;
	}
	
	public static double getArea(double r)
	{
		return Math.PI * r * r;
	}
}