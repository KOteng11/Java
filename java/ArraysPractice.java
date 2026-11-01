package arrays;

import java.util.Arrays;

public class ArraysPractice{
    public static void main(String[] args){
        int[] A = new int[5];
        
        for (int i = 0; i < 10; i++){
            if (isFull(i, A.length - 1)){
                A = increaseCapacity(A);
            }
          A[i] = i + 2;   
        }
        
        System.out.println(Arrays.toString(A));
    }
    
    public static int[] increaseCapacity(int[] arr){
        int[] temp = new int[arr.length * 2 + 1];
        
        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        
        return temp;
    }
    
    public static boolean isFull(int i, int capacity){
        return i == capacity;
    }
}