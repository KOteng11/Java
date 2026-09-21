import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(merge(A, B)));
    }
    
    public static int[] merge(int[] array1, int[] array2){
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        
        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]){
                combined[index++] = array1[i++];
            }else{
                combined[index++] = array2[j++];
            }
        }
        
        while (i < array1.length){
            combined[index++] = array1[i++];
        }
        
        while (j < array2.length){
            combined[index++] = array2[j++];
        }
        
        return combined;
    }
}