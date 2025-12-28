import java.lang.*;
import java.util.Scanner;

public class Cubiod
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		double length, height, width, totalArea, volume;
		
		System.out.print("Enter length: ");
		length = input.nextDouble();
		System.out.print("Enter width: ");
		width = input.nextDouble();
		System.out.print("Enter height: ");
		height = input.nextDouble();
		
		totalArea = 2 * ((length * height) + (width * height) + (length * width));
		volume = length * width * height;
		
		System.out.println("Total Area: " + totalArea);
		System.out.println("Volume: " + volume);
	}
}
