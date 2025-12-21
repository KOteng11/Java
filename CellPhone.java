/**
	The CellPhone class holds dat about a cell phone.
*/
public class CellPhone
{
	// Fields
	private String manufact;		// Manufacturer
	private String model;			// ModelMBean
	private double retailPrice;		// Retail price
	
	/**
		Constructor
		@param manufact The phone's manufacturer.
		@param model The phone's model number.
		@param price The phone's retail price.
	*/
	
	public CellPhone(String manufact, String model, double retailPrice)
	{
		this.manufact = manufact;
		this.model = model;
		this.retailPrice = retailPrice;
	}
	
	/**
		Copy Constructor
		@param other The other object to copy from
	*/
	public CellPhone(CellPhone other)
	{
		this(other.manufact, other.model, other.retailPrice);
	}
	
	/**
		The setModel method sets the phone's model number
		@param model The phone's model number.
	*/
	public void setModel(String model)
	{
		this.model = model;
	}
	
	/**
		getModel method
		@return The phone's model number
	*/
	public String getModel()
	{
		return model;
	}
	
	/**
		setManufact method
		@param manufact The sets the phone's manufacturer
	*/
	public void setManufact(String manufact)
	{
		this.manufact = manufact;
	}
	
	/**
		getManufact method
		@return The phone's manufacturer
	*/
	public String getManufact()
	{
		return manufact;
	}
	
	/**
		setRetailPrice method
		@param retailPrice The setRetailPrice method sets the phone's retail price
	*/
	public void setRetailPrice(double retailPrice)
	{
		this.retailPrice = retailPrice;
	}
	
	/**
		getRetailPrice method
		@return Returns the phone's retail price
	*/
	public double getRetailPrice()
	{
		return retailPrice;
	}
	
	/**
		compareModelPrice method
		@param other The other phone model to compare with
	*/
	public String compareModelPrice(CellPhone other)
	{
		if (this.retailPrice > other.retailPrice)
			return String.format("The price for %s %s is $%.2f more expensive that %s %s.", manufact, 
					model, Math.abs(retailPrice - other.retailPrice), other.manufact, other.model);
		if (this.retailPrice < other.retailPrice)
			return String.format("The price for %s %s is $%.2f less expensive that %s %s.", manufact, 
					model, Math.abs(retailPrice - other.retailPrice), other.manufact, other.model);
			return String.format("The price for %s %s is the same as %s %s.", manufact, 
					model, other.manufact, other.model);
	}
	
}