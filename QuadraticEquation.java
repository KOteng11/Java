import java.util.Scanner;

public class QuadraticEquation
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int a, b, c;
		double x1, x2;
		
		
		System.out.print("Enter a: ");
		a = input.nextInt();
		System.out.print("Enter b: ");
		b = input.nextInt();
		System.out.print ("Enter c: ");
		c = input.nextInt();
		x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
		x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
		System.out.println("x = " + x1 + " or x = " + x2);
	}
}