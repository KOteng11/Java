public class ArrayClass{
    private final int INITIAL_CAPACITY = 10;
    private int[] values;
    private int size = 0;
    
    public ArrayClass(int initialCapacity){
        values = new int[initialCapacity];
    }
    
    public ArrayClass(){
        this(INITIAL_CAPACITY);
    }
    
}