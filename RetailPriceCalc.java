import java.util.Scanner;	// import Scanner

public class RetailPriceCalc
{
	// Create a Scanner object for keyboard input
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		double retailPrice = calculateRetail();
		
		// display the retail price
		System.out.printf("Retail Price: %.2f%n", retailPrice);
	}
	
	public static double calculateRetail()
	{
		System.out.print("Enter wholesale cost and markup percentage separated by space: ");
		double cost = input.nextDouble();
		double percentage = input.nextDouble();
		
		return cost * (1 + percentage / 100.0);
	}
}