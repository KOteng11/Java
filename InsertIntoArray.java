public class InsertIntoArray
{
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		arr[0] = 5;
		arr[1] = 9;
		arr[2] = 6;
		arr[3] = 10;
		arr[4] = 12;
		arr[5] = 7;
		int count = 6;
		int index = 2;
		int value = 15;
		for (int num : arr)
			System.out.print(num + " ");
		
		int temp = arr[index];
		for (int i = count; i > index; i--)
			arr[i] = arr[i-1];
		arr[index] = value;
		count++;
		
		System.out.println();
		for (int num : arr)
			System.out.print(num + " ");
			
	}
}