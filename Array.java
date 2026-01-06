public class Array
{
	public static void main(String[] args)
	{
		int[] numbers = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};
		
		
	
		int max1, max2;
		max1 = max2 = numbers[0];
		
		for (int i = 1; i < numbers.length; i++)
		{
			if (numbers[i] > max1)
			{
				max2 = max1;
				max1 = numbers[i];
			}
			else if (numbers[i] > max2)
				max2 = numbers[i];
		}
		System.out.println(max2);
	}
}