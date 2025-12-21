import java.util.Scanner;

/**
	The program runs a simple test of the CellPhone class.
*/

public class CellPhoneTest
{
	public static void main(String[] args)
	{
		String testMan;		// To hold a manufacturer
		String testMod;		// To hold a model number
		double testPrice;	// To hold a price
		
		// Create a Scanner object for keyboard input
		Scanner input = new Scanner(System.in);
		
		// Get the manufacturer name.
		System.out.print("Enter the manufacturer: ");
		testMan = input.nextLine();
		
		// Get the model number.
		System.out.print("Enter the model number: ");
		testMod = input.nextLine();
		
		// Get the retail price.
		System.out.print("Enter the retail price: ");
		testPrice = input.nextDouble();
		
		// Create an instance of the CellPhone class, 
		// passing the data that was entered as arguments to the constructor
		CellPhone phone1 = new CellPhone(testMan, testMod, testPrice);
		CellPhone phone2 = new CellPhone("Apple", "Iphone 17", 1500);
		
		// Get the data from the phone and display it.
		System.out.println();
		System.out.println("Here is the data that you provided:");
		System.out.println("Manufacturer: " + phone1.getManufact());
		System.out.println("Model number: " + phone1.getModel());
		System.out.println("Retail Price: $" + phone1.getRetailPrice());
		System.out.println(phone1.compareModelPrice(phone2));
		
	}
}