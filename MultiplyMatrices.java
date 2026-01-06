public class MultiplyMatrices
{
	public static void main(String[] args)
	{
		int[][] arr1 = {{3,5,9}, {7,6,2}, {4,3,5}};
		int[][] arr2 = {{1,0,0}, {0,1,0}, {0,0,1}};
		int[][] arr3 = new int[3][3];
		

		for (int i = 0; i < arr1.length; i++)
		{
			for (int j = 0; j < arr1[i].length; j++)
			{
				for (int k = 0; k < arr1[i].length; k++)
						arr3[i][j] += arr1[i][k]*arr2[k][j];
			}
		}

		
		for (int[] arr : arr3)
		{
			for (int num : arr)
				System.out.print(num + " ");
			System.out.println();
		}
	}
}