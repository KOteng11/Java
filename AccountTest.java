import java.util.Scanner;

public class AccountTest
{
	public static void main(String[] args)
	{
		// Create an Account object and assign it to myAccount
		Account account1 = new Account("Kingsley", 50.00);
		Account account2 = new Account("Oteng", -7.53);
		
		// display initial value of name (null);
<<<<<<< HEAD
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
	
=======
		displayAccount(account1);
		displayAccount(account2);
		System.out.printf("%s balance: $%.2f%n",account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n",account2.getName(), account2.getBalance());
		
		// Create a Scanner object for keyboard input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter deposit amount for account1: "); // prompt
		double amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account1 balance%n%n", amount);
		account1.deposit(amount); // Add to account1 balance
		displayAccount(account1);
		displayAccount(account2);		
		System.out.print("Enter deposit amount for account2: "); // prompt
		amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account 2 balance%n%n", amount);
		account2.deposit(amount); // Add to account2 balance
		System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n", account2.getName(), account2.getBalance());
		
	}
	
	public void displayAccount(Account account)
	{
		System.out.printf("%s balance: $%.2f%n", account.getName(), account.getBalance());
	}
>>>>>>> 883333484ec051721b3b65f2c2522b1d1545f492
}
