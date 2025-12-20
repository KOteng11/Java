import java.util.Scanner;	// Needed for the Scanner object
import java.util.Random;	// Needed for the Random class
import java.io.*;			// Needed for file I/O classes

/**
	This program writes random numbers to a file
*/
public class ObjectDemo
{
	public static void main(String[] args) throws IOException
	{
		int maxNumbers;		// Max numbers of the random numbers
		int numbers;		// To hold a random number
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Create a Random object to generate random numbers.
		Random rand = new Random();
		
		// Create a PrintWriter object to open the file
		PrintWriter outputFile = new PrintWriter("numbers.txt");
		
		// Get the number of random numbers to writes
		System.out.print("How many random numbers should I write? ");
		maxNumbers = keyboard.nextInt();
		
		// Write the random numbers to the file
		for (int i = 0; i < maxNumbers; i++)
		{
			// Generate a random integer
			numbers = rand.nextInt();
			
			outputFile.println(numbers);
		}
		// Close the file
		outputFile.close();
		System.out.println("Done");
	}
}