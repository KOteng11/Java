import java.util.Scanner;

public class Tests
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		input.useRadix(2);
		System.out.print("Enter a number: ");
		int x = input.nextInt();
		
		System.out.println(x);
	}
}