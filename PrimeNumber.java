public class PrimeNumber
{
	public static void main(String[] args)
	{
		boolean prime;
		int number = 2;
		
		for (int i = 2; i < 100; i++)
		{
			prime = isPrime(number);
			
			if (prime)
				System.out.printf("%d is a prime number\n", number);
			else
				System.out.printf("%d is not a prime number\n", number);
			number++;
		}
	}
	
	public static boolean isPrime(int number)
	{
		for (int i = 2; i <= number / 2; i++)
		{
			if (number % i == 0)
				return false;
		}
		return true;
	}
}