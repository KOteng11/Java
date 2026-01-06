public class CopyArray
{
	public static void main(String[] args)
	{
		int[] arr = {8,6,10,9,2,15,7,13,14,11};
		int[] arr2 = new int[10];
		int[] arr3 = new int[10];
		
		for (int i = 0; i < arr.length; i++)
			arr2[i] = arr[i];
		
		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++)
			arr3[j] = arr[i];
		
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
		
		for (int num : arr3)
			System.out.print(num + " ");
	}
}