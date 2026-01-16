public class AutoPolicy
{
	private int accountNumber;	// to store the policy's account number
	private String makeAndModel;	// to store the car's make and model
	private String state;	// to store a two-character State abbreviation
	
	public AutoPolicy(int accountNumber, String makeAndModel,
				String state)
	{
		this.accountNumber = accountNumber;
		this.makeAndModel = makeAndModel;
		this.state = state;
	}
	
	/**
		setAccountNumber method
		@param accountNumber To store the policy's account number
	*/
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	/**
		getAccountNumber method
		@return getAccountNumber To retrieve the policy's account number
	*/
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
		setMakeAndModel method
		@param makeAndModel To store the car's make and model
	*/
	public void setMakeAndModel(String makeAndModel)
	{
		this.makeAndModel = makeAndModel;
	}
	
	/**
		getMakeAndModel method
		@return The car's make and model
	*/
	public String getMakeAndModel()
	{
		return makeAndModel;
	}
	
	/**
		setState method
		@param state To store a two-character State abbreviation
	*/
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
		getState method
		@return The state
	*/
	public String getState()
	{
		return state;
	}
	
	// predicate method returns whether the state has no-fault insurance
	public boolean isNoFaultState()
	{
		boolean noFaultState;
		
		// determine whether state  has no-fault auto insurance
		switch (getState())
		{
			case "MA":
			case "NJ":
			case "NY":
			case "PA":
				noFaultState = true;
				break;
			default:
				noFaultState = false;
		}
		
		return noFaultState;
	}
	
}