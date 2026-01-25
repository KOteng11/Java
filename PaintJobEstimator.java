import java.util.Scanner;

public class PaintJobEstimator
{
	private static final double BASE_SIZE = 115;
	private static final double BASE_HOURS = 8;
	private static final double BASE_CHARGES = 18.00;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter the number of rooms to be painted: ");
		int rooms = input.nextInt();
		
		System.out.print("Enter the price per gallon: ");
		double price = input.nextDouble();
		
		int totalSqFt = 0;
		for (int i = 1; i <= rooms; i++)
		{
			System.out.printf("Enter the square feet of wall space in room %d: ", i);
			totalSqFt += input.nextInt();
		}
		
		int noGallons = getNoGallons(totalSqFt);
		int hrs = getNoHoursRequired(totalSqFt);
		double paintCost = getPaintCost(price, noGallons);
		double laborCharges = calcLaborCharges(hrs);
		
		printWorkOrder(noGallons, hrs, paintCost, laborCharges);
	}
	
	// get the number of gallons required
	public static int getNoGallons(int totalSqFt)
	{
		return (int)Math.ceil(totalSqFt / (double)BASE_SIZE);
	}
	
	// get the number of hours required
	public static int getNoHoursRequired(int totalSqFt)
	{
		return (int)Math.ceil(totalSqFt * BASE_HOURS / (double)BASE_SIZE);
	}
	
	// calculate the cost of the paintCost
	public static double getPaintCost(double price, int noGallons)
	{
		return price * noGallons;
	}
	
	// calculate the labor charges
	public static double calcLaborCharges(int hrs)
	{
		return BASE_CHARGES * hrs;
	}
	
	// display the data on the screen
	public static void printWorkOrder(int noGallons, int hrs, double paintCost, double laborCharges)
	{
		System.out.printf("\nTotal number of gallons required: %d%nTotal number of hours required: %d%n" + 
			"Total cost of paint: %$.2f%nTotal labor cost: %$.2f%n", noGallons, hrs, paintCost, laborCharges);
	}
}