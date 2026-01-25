/**
	This program passes an object as an argument.
	The object is modified by the receiving method.
*/

public class PassObj2
{
	public static void main(String[] args)
	{
		// Create a Rectangle object.
		Rectangle box = new Rectangle(12.0, 5.0);
		
		// Display the object's content.
		System.out.println("Contents of the box object:");
		System.out.println("Length: " + box.getLength() + 
			" Width: " + box.getWidth());
			
		// Pass a reference to the object to the
		// changeRectangle method.
		changeRectangle(box);
		
		// Display the object's content.
		System.out.println("Contents of the box object:");
		System.out.println("Length: " + box.getLength() + 
			" Width: " + box.getWidth());		
	}
	
	public static void changeRectangle(Rectangle r)
	{
		r.setLength(0.0);
		r.setWidth(0.0);
	}
}