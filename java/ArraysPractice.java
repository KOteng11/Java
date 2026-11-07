package arrays;

import java.util.Arrays;

public class ArraysPractice{
    public static void main(String[] args){
        int[] B = {1, 2, 3, 4, 6, 8, 9, 10, 11, 12};
        int[] C = {3, 6, 8, 8, 10, 12, 15, 15, 15, 20};
        findDuplicates(C);
    }
    
    public static void findMissingElement(int[] A){
        int diff = A[1] - A[0];
        for (int i = 0; i < A.length - 1; i++){
            if (A[i+1]-A[i] != diff){
                int gap = A[i+1] - A[i];
                int curValue = A[i];
                for (int j = 0; j < gap - 1; j++){
                    System.out.println(curValue + diff);
                    curValue += diff;
                }
            }
        }
    }
    
    public static void findDuplicates(int[] A){
        int lastDuplicate = 0;
        
        for (int i = 0; i < A.length - 1; i++){
            if (A[i] == A[i+1] && A[i] != lastDuplicate){
                System.out.println(A[i]);
                lastDuplicate = A[i];
            }
        }
    }
}