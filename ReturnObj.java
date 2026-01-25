import javax.swing.JOptionPane;

public class ReturnObj
{
	public static void main(String[] args)
	{
		BankAccount account;
		
		// Get a reference to a BankAccount object.
		account = getAccount();
		
		// Display the account's balance
		JOptionPane.showMessageDialog(null, 
			"The account has balance of $" +
			account.getBalance());
	}
	
	public static BankAccount getAccount()
	{
		String input;	// To hold input
		double balance;	// Account balance
		
		// Get the balance from the user
		input = JOptionPane.showInputDialog("Enter " +
				"the account balance.");
		balance = Double.parseDouble(input);
		
		return new BankAccount(balance);
	}
}