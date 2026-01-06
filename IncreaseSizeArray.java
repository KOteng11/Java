public class IncreaseSizeArray
{
	public static void main(String[] args)
	{
		int[] arr = {8, 6, 10, 9, 2};
		int[] arr2 = new int[arr.length + 1];
		
		for (int num : arr)
			System.out.print(num + " ");
		
		for (int i = 0; i < arr.length; i++)
			arr2[i] = arr[i];
		arr2[5] = 1;
		arr = arr2;
		arr2 = null;
		
		System.out.println();
		for (int num : arr)
			System.out.print(num + " ");
	}
}