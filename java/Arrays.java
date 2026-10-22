package arrays;

public class Arrays{
    
    public static void main(String[] args){
        int[] arr = {6, 7, 8, 9, 11, 12, 15, 16, 17, 18, 19, 21, 23};
        
        
        
        
        //int diff = getDifference(arr);
        //findMissingElement(arr, diff);

        
        /**
        int maxElement = arr[arr.length - 1];
        int diff = arr[0] - 0;
        
        int totalElement = ((maxElement * (maxElement + 1))-(diff -1) * diff)/2;
        int actual = 0;
        for (int i = 0; i < arr.length; i++){
            actual += arr[i];
        }
        
        System.out.println(totalElement - actual);
        
        */
    }
    
    public static void findingDuplicate(int[] arr){
        for (int i = 0; i < arr.length - 1){
            count = 1;
            if (arr[i] != -1){
                for (int j = i+1; j < arr.length; i++){
                    if (arr[i] == arr[j]){
                        count++;
                        arr[j] = -1;
                    }
                }
            }
            if (count > 1)
                System.out.println(count);
        }
    }
    
    public static void findMissingElement(int[] arr, int diff){
        int count = 1;
        int initial = arr[0];
        
        while (count < arr.length){
            if (initial + diff != arr[count]){
                System.out.println((initial + diff) + " is missing."); 
                initial += diff;
            }else{
                initial = arr[count++];
            }
        }        
    }
    
    public static int getDifference(int[] arr){
        boolean foundDiff = false;
        int i = 0;
        int diff = 0;
        while (!foundDiff){
            if (arr[i] + 1 == arr[i+1]){
                foundDiff = true;
                diff = arr[i+1] - arr[i];
            }
            i++;
        }   

        return diff;
    }
}