public class DisplayDigits
{
	public static void main(String[] args)
	{
		/*
		int num = 25784;
		int count = 0;
		
		while (num != 0)
		{
			++count;
			num /= 10;
		}
		
		System.out.println(count);*/
		
		boolean armstrong = isArmstrong(371);
		
		System.out.println(armstrong);
	}
	
	public static boolean isArmstrong(int number)
	{
		int n = number;
		int remainder;
		int total = 0;
		
		while (number > 0)
		{
			remainder = number % 10;
			total += remainder * remainder * remainder;
			number /= 10;
		}
		
		return total == n;
	}
}