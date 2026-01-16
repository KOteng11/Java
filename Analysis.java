// Analysis of examination results using nested
// control statements.
import java.util.Scanner;	// Class uses Scanner

public class Analysis
{
	public static void main(String[] args)
	{
		// Create a Scanner object for keyboard input
		Scanner input = new Scanner(System.in);
		
		// initializing variables in declarations
		int passes = 0;
		int failures = 0;
		int counter = 1;
		
		// Process 10 students using counter-controlled loop
		while (counter <= 10)
		{
			// Prompt user for input and obtain value from user
			System.out.print("Enter result (1 = pass, 2 = fail): ");
			int result = input.nextInt();
			
			if (result == 1)
				passes += 1;
			else
				failures += 1;
			
			counter++;
		}
		
		// termination phase; prepare and display results
		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
		
		// determine whether more than 8 students passed.
		if (passes > 8)
			System.out.println("Bonus to instructor");
	}
}