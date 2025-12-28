import java.util.Scanner;

public class AreaTriangle
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		float base, height, area;
		
		System.out.print("Enter base of the triangle: ");
		base = input.nextFloat();
		System.out.print("Enter height of the triangle: ");
		height = input.nextFloat();
		area = 0.5f*(base*height);
		System.out.println("The area the of the triangle is: " + area);
	}
}