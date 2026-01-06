public class LeftRotation
{
	public static void main(String[] args)
	{
		int[] arr = {5,9,6,10,12,7,3,5,4,2};
		int temp = arr[0];
		
		for (int num : arr)
			System.out.print(num + " ");
		
		for (int i = 0; i < arr.length - 1; i++)
			arr[i] = arr[i+1];
		arr[arr.length - 1] = temp;
		
		System.out.println();
		for (int num : arr)
			System.out.print(num + " ");
	}
}