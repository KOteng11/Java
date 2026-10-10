package sortpractice;

import java.util.Arrays;

public class SortPractice{
    public static void main(String[] args){
        int[] arr = {10, 3, 12, 7, 2, 11, 9};
        
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        int[] arr1 = mergeSort(arr);
        System.out.println(Arrays.toString(arr1));
    }
    
    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            for (int k = 0; k < i; k++){
                if (arr[k] > arr[k+1]){
                    swap(arr, k, k+1);
                }
            }
        }
    }
    
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int k = i + 1; k < arr.length; k++){
                if (arr[k] < arr[minIndex]){
                    minIndex = k;
                }
            }
            if (i != minIndex){
                swap(arr, i, minIndex);
            }
        }
    }
    
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int k = i; k > 0 && arr[k-1] > arr[k];k--){
                swap(arr, k-1, k);
            }
        }
    }
    
    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int midIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));
        return merge(left, right);
    }
    
    private static int[] merge(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        while(i < arr1.length){
            arr3[k++] = arr1[i++];
        }
        while(j < arr2.length){
            arr3[k++] = arr2[j++];
        }
        
        return arr3;
    }
    
    private static void swap(int[] A, int pos1, int pos2){
        int temp = A[pos1];
        A[pos1] = A[pos2];
        A[pos2] = temp;
    }
}