public class ArrayDeleteElement
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
		int size = 6;
		int index = 1;
		for (int num : arr)
			System.out.print(num + " ");
		
		for (int i = index; i < size - 1; i++)
			arr[i] = arr[i+1];
		--size;
		
		System.out.println();
		for (int num : arr)
			System.out.print(num + " ");
	}
}