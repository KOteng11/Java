package merging;

public class Merging{
    public static void main(String[] args){
        int[] arr1 = {2, 6, 10, 15, 25};
        int[] arr2 = {3, 4, 7, 18, 20, 29};
        int[] arr3;
        
        arr3 = merge(arr1, arr2);
        for (int x : arr3){
            System.out.print(x + " ");
        }
    }
    
    public static int[] merge(int[] A, int[] B){
        int i, j, k;
        i=j=k=0; 
        int[] C = new int[A.length + B.length];
        
        while(i < A.length && j < B.length){
            if (A[i] < B[j]){
                C[k++] = A[i++];
            }else{
                C[k++] = B[j++];
            }
        }
        while (i < A.length){
            C[k++] = A[i++];
        }
        while (j < B.length){
            C[k++] = B[j++];
        }
        
        return C;
    }
}