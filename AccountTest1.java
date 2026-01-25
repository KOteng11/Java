import java.security.SecureRandom;
import java.util.ArrayList;

class Account
{
	public static ArrayList<Long> accNumbers = new ArrayList<>();
	
	private long accNo;	// The account number
	private String name;	// The name of the account holder
	private String address; // The address of the accountholder
	private int phoneNo;	// The phone number of the account holder
	private String dob;		// The account holder's date of birth
	protected double balance;	// balance of the account
	
	Account(String name, String address, int phoneNo, String dob, int initialBalance)
	{	
		balance = 0;

		boolean exists;
		do
		{
			accNo = generateAccountNumber();
			exists = checkAccountExistence();
		}
		while (exists);
		
		if (!exists)
			accNumbers.add(accNo);
		
		System.out.println(accNo);
		System.out.println(accNumbers);

		if(!name.isEmpty())
			this.name = name;
		
		if (!address.isEmpty())
			this.address = address;
		
		this.phoneNo = phoneNo;
		
		if (!dob.isEmpty())
			this.dob = dob;
		
		if (initialBalance > 0)
			this.balance = initialBalance;
	}
	
	private long generateAccountNumber()
	{
		SecureRandom rand = new SecureRandom();
		return 10000000L + rand.nextLong(99999999);	
	}
	
	private boolean checkAccountExistence()
	{
		if (accNumbers.isEmpty())
			return false;
		for (int i = 0; i < accNumbers.size(); i++)
		{
			if (accNo == accNumbers.get(i))
				return true;
		}
		return false;
	}
	

	public void setName(String name)
	{
		if(!name.isEmpty())
			this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAddress(String address)
	{
		if (!address.isEmpty())
			this.address = address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setPhoneNo(int phoneNo){this.phoneNo = phoneNo;}
	
	public int getPhoneNo(){return phoneNo;}
	
	public void setDob(String dob)
	{
		if (!dob.isEmpty())
			this.dob = dob;
	}
	
	public String getDob(){return dob;}
	
	public void closeAccount()
	{
		System.out.println("Account is closed");
	}
	
	public double getBalance()
	{
		return balance;
	}

}

class SavingsAccount extends Account
{
	SavingsAccount(String name, String address, int phoneNo, String dob, int initialBalance)
	{
		super(name, address, phoneNo, dob, initialBalance);
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdraw(double amt)
	{
		balance -= amt;
	}
}

public class AccountTest1
{
	public static void main(String[] args)
	{
		Account acc1 = new SavingsAccount("Kingsley Darko", "2D143", 234234234, "1989-10-04", 500);
		
		System.out.println(acc1.getBalance());
		
		acc1.deposit(200);
		
		System.out.println(acc1.getBalance());
		
		acc1.withdraw(500);
		System.out.println(acc1.getBalance());
	}
	

}