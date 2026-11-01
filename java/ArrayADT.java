package arrayadt;

public class ArrayADT<T>{
    public static final int DEFAULT_CAPACITY = 10;
    T[] values;
    int size;
    
    @SuppressWarnings("unchecked");
    public ArrayADT(int initialCapacity){
        values = (T[])new Object[initialCapacity];
        size = 0;
    }
    
    public ArrayADT(){
        this(DEFAULT_CAPACITY);
    }
}