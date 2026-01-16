public class Gcd
{
	public static void main(String[] args)
	{
		int gcd = getGcd(13, 20);
		System.out.println(gcd);
	}
	
	public static int getGcd(int m, int n)
	{
		while (m != n)
		{
			if (m > n)
				m -= n;
			else
				n -= m;
		}
		
		return m;
	}
}