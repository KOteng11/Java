// Craps.java

// Craps class simulates the dice game craps.
import java.security.SecureRandom;

public class Craps
{
	// create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumber = new SecureRandom();
	
	// enum type with constants that represent the game status
	private enum Status{CONTINUE, WON, LOST};
	
	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	// plays game of craps
	public static void main(String[] args)
	{
		int myPoint = 0; // points if no win or loss on the first rollDice
		Status gameStatus;	// can contain CONTINUE, or LOST
		
		int sumOfDice = rollDice();	// first roll of the dice
		
		// determine game status and point based on first roll
		switch (sumOfDice)
		{
			case SEVEN, YO_LEVEN:
				gameStatus = Status.WON;
				break;
			case SNAKE_EYES, TREY, BOX_CARS:
				gameStatus = Status.LOST;
				break;
			default:
				gameStatus = Status.CONTINUE;	// game is not over
				myPoint = sumOfDice;
				System.out.printf("Point is %d%n", myPoint);
				break;
		}
		
		while (gameStatus == Status.CONTINUE)
		{
			sumOfDice = rollDice();	// roll dice again
			
			// determine game status
			if(sumOfDice == myPoint)
			{
				gameStatus = Status.WON;
			}
			else if (sumOfDice == SEVEN)
			{
				gameStatus = Status.LOST;
			}
		}
		
		// display won or lost message
		if (gameStatus == Status.WON)
			System.out.println("Player wins");
		else
			System.out.println("Player loses");
	}
	
	// roll dice, calculate sum and display results
	public static int rollDice()
	{
		int die1 = 1 + randomNumber.nextInt(6);
		int die2 = 1 + randomNumber.nextInt(6);
		
		int sum = die1 + die2;
		
		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
		
		return sum;
	}
}