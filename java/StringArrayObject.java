public class StringArrayObject{
    private static final int DEFAULT_CAPACITY = 10;
    private String[] values;
    private int size = 0;
    
    public StringArrayObject(int initialCapacity){
        values = new String[initialCapacity];
    }
    
    // No-args constructor
    public StringArrayObject(){
        this(DEFAULT_CAPACITY);
    }
    
    // Display elements in an array
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++){
            sb.append(values[i] + ", ");
        }
        
        return sb.toString();
    }
    
    // Add element
    public void add(String s){
        if (arrayIsFull()){
            increaseCapacity();
        }
        values[size++] = s;
    }
    
    // Add by index
    public void add(int i, String s){
        if (!isValidIndex(i)){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (arrayIsFull()){
            increaseCapacity();
        }
        for (int counter = size; counter > i; counter--){
            values[counter] = values[counter - 1];
        }
        values[i] = s;
        size++;
    }
    
    public boolean arrayIsFull(){
        return size == values.length;
    }
    
    public void increaseCapacity(){
        
        String[] temp = new String[values.length * 2 + 1];
        System.out.println("Resizing the array...");
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
    }
    
    public boolean isValidIndex(int index){
        return (index >= 0 && index < size);
    }
    
    public static void main(String[] args){
        StringArrayObject s = new StringArrayObject();
        for (int i = 1; i < 15; i++){
            s.add(String.valueOf(i));
        }
        
        System.out.println(s);
    }
}