package emailapp;

import java.util.Scanner;

public class Email
{
	public static Email getInput()
	{
		return new Email("John", "Smith");
	}
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private final int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName)
	{
		if (!firstName.isEmpty() && !lastName.isEmpty())
		{
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + password);
		
		// Combine elements to generate email
		if (department.isEmpty())
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
		else
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +companySuffix;
	}
	
	// Ask for the department
	private String setDepartment()
	{
		System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner input = new Scanner(System.in);
		int deptChoice = input.nextInt();
		
		if (deptChoice == 1)
			return "sales";
		else if (deptChoice == 2)
			return "dev";
		else if (deptChoice == 3)
			return "acct";
		else 
			return "";
	}
	// Generate a random password
	private String randomPassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++)
		{
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailBoxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail)
	{
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password)
	{
		this.password = password;
	}
	
	public int getMailBoxCapacity()
	{
		return mailboxCapacity;
	}
	
	public String getAlternateEmail()
	{
		return alternateEmail;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String showInfo()
	{
		return  "\nDISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}