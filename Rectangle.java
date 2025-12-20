public class Rectangle
{
	private double length;
	private double width;
	
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	
	public Rectangle(double length)
	{
		this(length, 10);
	}
	
	public Rectangle()
	{
		this(0.0, 0.0);
	}
	
	public Rectangle(Rectangle other)
	{
		this(other.length, other.width);
	}
	
	public void setLength(double length)
	{
		this.length = length;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getArea()
	{
		return length * width;
	}
	
	public static void main(String[] args)
	{
		Rectangle test1 = new Rectangle(20, 10);
		Rectangle test2 = new Rectangle(test1);
		Rectangle box = new Rectangle();
		box.setLength(10.0);
		box.setWidth(20.0);
		System.out.println(box.getArea());
	}
}