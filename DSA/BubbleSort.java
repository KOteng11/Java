public class BubbleSort
{
    public static void main(String[] args){
        int[] A = {3, 7, 9, 10, 6, 5, 12, 4, 11, 2};
        
        sort(A);
        
        for (int x : A){
            System.out.println(x);
        }
    }
    
    public static void bubbleSort(int[] B){
        boolean isSorted = false;
        int k;
        
        while(!isSorted){
            isSorted = true;
            k = 0;
            for (int i = 0; i < B.length - 1-k; i++){
                if(B[i] > B[i+1]){
                    isSorted = false;
                    swap(B, i, i+1);
                }
            }
            k++;
        }
    }
    
    public static void insertionSort(int[] B){
        for (int i = 1; i < B.length; i++){
            for (int k = i; k > 0 && B[i-1] > B[i]; k--){
                swap(k, k-1);
            }
        }
    }
    
    public static void swap(int[] B,int i,int k){
        int temp = B[i];
        B[i] = B[k];
        B[k] = temp;
    }
}