import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class CountCharacter
{
	public static void main(String[] args)
	{
		count("abcdabcdabcdabc");
	}
	
	public static void count(String str)
	{	
		HashSet<Character> uniqueChar =  new HashSet<>();
		HashMap<Character, Integer> dict = new HashMap<>();
		
		for (char ch : str.toCharArray())
        {
          dict.put(ch, dict.get(ch) + 1);
        }
		
		System.out.println(dict);
	}
}