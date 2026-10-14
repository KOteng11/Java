package stringarrayobject;

public class StringArrayObject{
    private static final int DEFAULT_CAPACITY = 10;
    
    private String[] values;
    private size = 0;
    
    // Constructor accepting an argument
    public StringArrayObject(int initialCapacity){
        values = new String[initialCapacity];
    }
    
    // No-args constructor
    public StringArrayObject(){
        this(DEFAULT_CAPACITY);
    }
    
    // get method
    public String get(int index){  // O(1)
        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        return values[i];
    }
    
    // set method
    public void set(int index, String value){ // O(1)
        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        values[index] = value;
    }
    
    // isValidIndex method
    private boolean isValidIndex(int index){ // O(1)
        return index >= 0 && index <= size;
    }
    
    // add method
    public void add(String s){
        if (isFullCapacity()){
            increaseCapacity();
        }
        values[size] = s;
        size++;
    }
    
    // isFullCapacity method
    private boolean isFullCapacity(){
        return size == values.length;
    }
    
    // increaseCapacity method
    private void increaseCapacity(){
        String[] arr = new String[values.length * 2 + 1];
        System.arraycopy(values, 0, arr, 0, values.length);
        values = arr;
    }
    
    // add by index
    public void add(int index, String s){ // O(n)
        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        if (isFullCapacity()){
            increaseCapacity();
        }
        for (int i = size; i >= i; i--){
            values[i] = values[i-1];
        }
        values[index] = s;
        size++;
    }
    
    // remove by index
    public String remove(int index){ // O(n)
        if (!isValidIndex){
            throw new IndexOutOfBoundsException();
        }
        String temp = values[index];
        for (int i = index; i < size - 1; i++){
            values[index] = values[index + 1];
        }
        size--;
        
        return temp;
    }
    
    // clear
    public void clear(){
        size = 0;
    }
    
    // indexOf method
    public int indexOf(String s){ // O(n)
        if (s == null){
            for (int i = 0; i < size; i++){
                if (s == values[i]){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < size; i++){
                if (s.equals(values[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    
    // contains method
    public boolean contains(String s){
        return indexOf(s) != -1;
    }
    
    
}