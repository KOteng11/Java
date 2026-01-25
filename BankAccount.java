/**
	The BankAccount class simulates a bank account.
*/

public class BankAccount
{
	private double balance;		// Account balance
	
	/**
		This constructor sets the starting balance at 0.0
	*/
	public BankAccount()
	{
		this.balance = 0.0;
	}
	
	/**
		This constructor sets the starting balance to the value passesd as an argument.
		@param balance The starting balance.
	*/
	public BankAccount(double balance)
	{
		this.balance = balance;
	}
	
	/**
		This constructor sets the starting balance to the value in the String argument
		@param balance The starting balance, as a string
	*/
	public BankAccount(String balance)
	{
		this.balance = Double.parseDouble(balance);
	}
	
	/**
		Copy Constructor
	*/
	public BankAccount(BankAccount object2)
	{
		this.balance = object2.balance;
	}
	
	/**
		The deposit method makes a deposit into the account.
		@param amount The amount to add to the balance field
	*/	
	public void deposit(double amount)
	{
		this.balance += amount;
	}
	
	/**
		The deposit method makes a deposit into the account.
		@param amount The amount to add to the balance, as a String.
	*/
	public void deposit(String amount)
	{
		this.balance += Double.parseDouble(amount);
	}
	
	/**
		The withdraw method withdraws an amount from the account.
		@param amount The amount to substract from the balance.
	*/
	public void withdraw(double amount)
	{
		this.balance -= amount;
	}
	
	/**
		The withdraw method withdraws an amount fromt he account.
		@param amount The amount to substract from the balance, as a String.
	*/
	public void withdraw(String amount)
	{
		this.balance -= Double.parseDouble(amount);
	}
	
	/**
		The setBalance method sets the account balance.
		@param balance The value to store in the balance field.
	*/
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	/**
		The setBalance method sets the account balance.
		@param balance The value to store in the balance field, as a String.
	*/
	public void setBalance(String balance)
	{
		this.balance = Double.parseDouble(balance);
	}
	
	/**
		The getBalance method returns the account balance.
		@return The value in the balance field.
	*/
	public double getBalance()
	{
		return this.balance;
	}
}