import java.util.Scanner;

public class ReverseNumber
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number to reverse: ");
		int num = input.nextInt();
		int reverse = reverseNumber(num);
		System.out.println("Reverse: " + reverse);
		
		if (num == reverse)
			System.out.printf("%d is a palindrome.", num);
		else
			System.out.printf("%d is not a palindrome.", num);
	}
	
	public static int reverseNumber(int num)
	{
		int r = 0;
		
		while (num > 0)
		{
			r = r * 10 + (num % 10);
			num /= 10;
		}
		return r;
	}
}