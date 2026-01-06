public class Account
{
	private String name;
	private double balance;

	public Account(String name, double balance)
	{
		this.name = name;
		if (balance > 0.0)
			this.balance = balance;
	}
	/**
	public Account()
	{
		this("");
	}*/
	
	public void deposit(double amount)
	{
		if (amount > 0.0)
			balance += amount;
	}
	
	public void withdrawal(double amount)
	{
		if (amount > 0.0 && amount <= balance)
			balance -= amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setName(String name)
	{
		this.name = name;	// Store the name
	}
	
	
	public String getName()
	{
		return name;
	}
<<<<<<< HEAD
	
	public String toString()
	{
		return String.format("%s balance: $%.2f%n", getName(), getBalance());
	}
=======
>>>>>>> 883333484ec051721b3b65f2c2522b1d1545f492
}