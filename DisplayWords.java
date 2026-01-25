public class DisplayWords
{
	public static void main(String[] args)
	{
		
		String words = displayWords(237);
		System.out.println(words);
	}
	
	public static String displayWords(int num)
	{
		String rev = "";
		int r;
		
		while (num > 0)
		{
			r = num % 10;
			rev += r;
			num /= 10;
		}
		
		for (int i = rev.length() - 1; i >= 0; i--)
		{
			
		}
		return rev;
	}
}