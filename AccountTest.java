import java.util.Scanner;

public class AccountTest
{
	public static void main(String[] args)
	{
		// Create an Account object and assign it to myAccount
		Account account1 = new Account("Kingsley", 50.00);
		Account account2 = new Account("Oteng", -7.53);
		
		// display initial value of name (null);
		System.out.print(account1);
		System.out.print(account2);
		
		// Create a Scanner object for keyboard input
		// Scanner input = new Scanner(System.in);
		
		depositAmount("Enter deposit amount for account1: ", account1);
		System.out.print(account1);
		System.out.print(account2);	
		
		depositAmount("Enter deposit amount for account2: ", account2);
		System.out.print(account1);
		System.out.print(account2);
		
		withdrawAmount("Enter amount to withdraw for account1: ", account1);
		System.out.print(account1);
		System.out.print(account2);
		
		withdrawAmount("Enter amount to withdraw for account2: ", account2);
		System.out.print(account1);
		System.out.print(account2);		
	}
	
	public static void withdrawAmount(String prompt, Account account)
	{
		// Create a Scanner object for keyboard input.
		Scanner input = new Scanner(System.in);
		
		System.out.print(prompt);
		double amount = input.nextDouble();
		if (account.getBalance() < amount)
			System.out.println("\nWithdrawal amount exceeds account Balance\n.");
		else
		{
			System.out.printf("%nwithdrawing %.2f from %s's account%n%n", amount, account.getName());
			account.withdrawal(amount);
		}
	}
	
	public static void depositAmount(String prompt, Account account)
	{
		// Create a Scanner object for keyboard input.
		Scanner input = new Scanner(System.in);
		
		System.out.print(prompt);
		double amount = input.nextDouble();
		System.out.printf("%nadding %.2f to %s's account%n%n", amount, account.getName());
		account.deposit(amount);	// Adding to the account balance
	}
	
}
