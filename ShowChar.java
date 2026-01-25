public class ShowChar
{
	public static void main(String[] args)
	{
		System.out.println(showChar("New York", 2));
	}
	
	public static char showChar(String word, int index)
	{
		return word.charAt(index);
	}
}