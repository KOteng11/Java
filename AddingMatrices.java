public class AddingMatrices
{
	public static void main(String[] args)
	{
		int[][] arr1 = {{3,5,9}, {7,6,2}, {4,3,5}};
		int[][] arr2 = {{1,5,2}, {6,8,4}, {3,9,7}};
		int[][] arr3 = new int[3][3];
		
		for (int i = 0; i < arr1.length; i++)
		{
			for (int j = 0; j < arr1[i].length; j++)
				arr3[i][j] = arr1[i][j]+arr2[i][j];
		}
		
		for (int[] arr : arr3)
		{
			for (int num : arr)
				System.out.print(num + " ");
			System.out.println();
		}
	}
}