import java.util.Scanner;

public class Invoice
{
	public static Invoice getInput()
	{
		// Create a Scanner Object for keyboard input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter partnumber: ");
		String partNumber = input.nextLine();
		
		System.out.print("Enter part description: ");
		String partDesc = input.nextLine();
		
		System.out.print("Enter quantity: ");
		int quantity = input.nextInt();
		
		System.out.print("Enter price per item: ");
		double price = input.nextDouble();
		
		return new Invoice(partNumber, partDesc, quantity, price);	
	}
	
	private String partNumber;
	private String partDesc;
	private int quantity;
	private double price;
	
	public Invoice(String partNumber, String partDesc, int quantity, 
			double price)
	{
		this.partNumber = partNumber;
		this.partDesc = partDesc;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Invoice(Invoice other)
	{
		this(other.partNumber, other.partDesc, other.quantity, other.price);
	}
	
	public void setPartNumber(String partNumber)
	{
		if (!partNumber.equals(""));
			this.partNumber = partNumber;
	}
	
	public String getPartNumber()
	{
		return this.partNumber;
	}
	
	public void setPartDesc(String partDesc)
	{
		this.partDesc = partDesc;
	}
	
	public String getPartDesc()
	{
		return partDesc;
	}
	
	public void setQuantity(int quantity)
	{
		if (quantity > 0)
			this.quantity = quantity;
		else
			quantity = 0;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setPrice(double price)
	{
		if (price > 0.0)
			this.price = price;
		else
			price = 0.0;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public double getInvoiceAmount()
	{
		return quantity * price;
	}
	
	public String toString()
	{
		System.out.printf("%-20s%-20s%-12s%-10s%-10s%n", "Part Number", "Part Description", "Quantity", 
			"Price", "Total Amount");
		return String.format("%-20s%-20s%-12d$%-10.2f%-10.2f%n", partNumber, partDesc, quantity,
					price, getInvoiceAmount());
	}
	
}