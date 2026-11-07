package arrayadt;

import java.util.*;

public class ArrayADT<T extends Comparable<T>>{
    private static final int DEFAULT_CAPACITY = 10;
    T[] values;
    int size;
    
    @SuppressWarnings("unchecked")
    public ArrayADT(int initialCapacity){
        values = (T[])new Comparable[initialCapacity];
        size = 0;
    }
     
    public ArrayADT(){
        this(DEFAULT_CAPACITY);
    }
    
    public void display(){
        if (isEmpty()){
            throw new NoSuchElementException("Array is empty.");
        }
        for (int i = 0; i < size; i++){
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    
    public void add(T element){
        if (isFull()){
            increaseCapacity();
        }
        values[size] = element;
        size++;
    }
    
    public void insert(int index, T element){
        if (!isValidPosition(index)){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        if (isFull()){
            increaseCapacity();
        }
        for (int i = size; i > index; i--){
            values[i] = values[i-1];
        }
        values[index] = element;
        size++;
    }
    
    public T delete(int index){
        if (!isValidElement(index)){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        T temp = values[index];
        for (int i = index; i < size - 1; i++){
            values[i] = values[i+1];
        }
        size--;
        
        return temp;
    }
    
    public boolean isValidElement(int index){
        return index >= 0 && index < size;
    }
    
    @SuppressWarnings("unchecked")
    private void increaseCapacity(){
        Comparable[] temp = new Comparable[values.length * 2 + 1];
        System.arraycopy(values, 0, temp, 0, size);
        
        values = (T[]) temp;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    private boolean isFull(){
        return size == values.length;
    }
    
    private boolean isValidPosition(int index){
        return index >= 0 && index <= size;
    }
    
    public int linearSearch(T key){
        for (int i = 0; i < size; i++){
            if (Objects.equals(values[i],key)){
                return i;
            }
        }
        return -1;
    }
    
    public int improvedLinearSearch(T key){
        for(int i = 0; i < size; i++){
            if (Objects.equals(values[i], key)){
                swap(i, i-1);
                return i-1;
            }
        }
        return -1;
    }
    
    
    private void swap(int x, int y){
        T temp = values[x];
        values[x] = values[y];
        values[y] = temp;
    }
    
    public boolean isSorted(){
        if (size <= 1){
            return true;
        }
        for (int i = 1; i < size; i++){
            if (values[i].compareTo(values[i-1]) == -1){
                return false;
            }
        }
        return true;
    }
    
    public T get(int index){
        if (!isValidElement(index)){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return values[index];
    }
    
    public void set(int index, T value){
        if (!isValidElement(index)){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        values[index] = value;
    }
    
    public T max(){
        T max = values[0];
        for (int i = 0; i < size; i++){
            if (values[i].compareTo(max) == 1){
                max = values[i];
            }
        }
        return max;
    }
    
    public T min(){
        T min = values[0];
        for (int i = 0; i < size; i++){
            if (values[i].compareTo(min) == -1){
                min = values[i];
            }
        }
        return min;
    }
    
    @SuppressWarnings("unchecked")
    public void reverse(){
        Comparable[] temp = new Comparable[size];
        for (int i = size-1, j=0; i >= 0; i--, j++){
            temp[j] = values[i];
        }
        values = (T[])temp;
    }
    
    public void reverse2(){
        for (int i = 0, j = size-1; i < j; i++, j--){
            swap(i, j);
        }
    }
    
    
    /**
    public int sum(){
        int total = 0;
        
        for (int i = 0; i < size; i++){
            total += values[i];
        }
        
        return total;
    }
    
    public double avg(){
        return (double)sum()/ size;
    }
    */
    
    /**
    public int binarySearch(T key){
        int lo = 0;
        int hi = size - 1;
        int mid;
        
        while (lo <= hi){
            mid = (lo + hi)/2;
            if (key == values[mid]){
                return mid;
            }
            if (key < values[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }*/
    
    public static void main(String[] args){
        ArrayADT<Integer> A = new ArrayADT<>();
        Random rand = new Random();
        //A.add(10);
        //A.add(12);
        
        for (int i = 0; i < 10; i++){
             A.add(rand.nextInt(50 - 25 + 1)+25);
        }
        
        A.display();
        A.reverse2();
        A.display();
    }
}