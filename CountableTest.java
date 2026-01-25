class Countable
{
	private static int instanceCount = 0;
	
	/**
		The constructor increments the static
		field instanceCount. This keeps track
		of the number of instances of this class
		that are created
	*/
	
	public Countable()
	{
		++instanceCount;
	}
	
	/**
		The getInstanceCount method returns
		the number of instances of this class
		that have been created
		@return The value in the instanceCount field
	*/	
	public int getInstanceCount()
	{
		return instanceCount;
	}
}

public class CountableTest
{
	public static void main(String[] args)
	{
		Countable c1 = new Countable();
		Countable c2 = new Countable();
		Countable c3 = new Countable();
		
		System.out.println(c1.getInstanceCount());
	}
}