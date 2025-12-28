import java.util.Scanner;

public class BinaryToDecimal
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		input.useRadix(2);
		System.out.print("Enter Binary number: ");
		int binary = input.nextInt();
		
		System.out.println(binary);
	}
}