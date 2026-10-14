package arrayclass;

public class ArrayClass{
    private static final int DEFAULT_CAPACITY = 10;
    private int[] values;
    private int size = 0;
    
    // Constructor
    public ArrayClass(int initialCapacity){
        values = new int[initialCapacity];
    }
    
    // No-args constructor
    public ArrayClass(){
        this(DEFAULT_CAPACITY);
    }
    
    // Destructor
    public void clear(){
        size = 0;
    }
    
    // display method
    public void Display(){
        for (int i = 0; i < size; i++){
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    
    // insert method
    public void insert(int index, int x){
        if (!isPositionIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        if (isFullCapacity()){
            increaseCapacity();
        }
        
        for (int i = size; i > index; i--){
            values[i] = values[i-1];
        }
        values[index] = x;
        size++;
    }
    
    public boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }
    
    public boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }
    
    private boolean isFullCapacity(){
        return size == values.length;
    }
    
    private void increaseCapacity(){
        int[] temp = new int[values.length * 2 + 1];
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
    }
    
    // delete method
    public int delete(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        int temp = values[index];
        for (int i = index; i < size - 1; i++){
            values[i] = values[i+1];
        }
        size--;
        
        return temp;
    }
    
    // get method
    public int get(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }
    
    // get method
    public void set(int index, int value){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        values[index] = value;
    }
    
    // size method
    public int size(){
        return size;
    }
    
    
    
    
}