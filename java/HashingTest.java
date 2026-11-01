package hashingtest;

import java.util.Arrays;

public class HashingTest
{
    public static final int SIZE = 10;
    
    public static void main(String[] arg){
        int[] HT = new int[SIZE];
        Arrays.fill(HT, 0);
        
        insert(HT, 12);
        insert(HT, 25);
        insert(HT, 35);
        insert(HT, 26);
        
        System.out.println("Key found at " + search(HT, 35));
    }
    
    public static int probe(int[] H, int key){
        int index = hash(key);
        int i = 0;
        
        while(H[(index + i) % SIZE] != 0){
            i++;
        }
        
        return (index + i) % SIZE;
    }
    
    public static int search(int H[], int key){
        int index = hash(key);
        
        int i = 0;
        
        while(H[(index + i) % SIZE] != key){
            i++;
        }
        
        return (index + i)% SIZE;
    }
    
    public static void insert(int[] H, int key){
        int index = hash(key);

        if (H[index] != 0){
            index = probe(H, key);
        }
        H[index] = key;
    }
    
    public static int hash(int key){
        return key % SIZE;
    }
}