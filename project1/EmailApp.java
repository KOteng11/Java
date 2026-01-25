package emailapp;

public class EmailApp
{
	public static void main(String[] args)
	{
		Email em1 = Email.getInput();
		System.out.println(em1.showInfo());
	}
}