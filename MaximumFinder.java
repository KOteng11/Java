// Programmer-declared method maximum with 
// t0.
hree double parameters.

import java.util.Scanner;

public class MaximumFinder
{
	public static void main(String[] args)
	{
		// Create a Scanner object for keyboard input
		Scanner input = new Scanner(System.in);
		
		// prompt for and input three floating point values
		System.out.print("Enter three floating-point values " + 
				"separated by spaces: ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		// determine the maximum values
		double result = maximum(number1, number2, number3);
		
		// display maximum values
		System.out.println("Maximum is: " + result);
	}
	
	// returns the maximum of its three double parameters
	public static double maximum(double number1, double number2, double number3)
	{
		double max = number1;
		if (number2 > max)
			max = number2;
		if (number3 > max)
			max = number3;
		
		return max;
	}
}