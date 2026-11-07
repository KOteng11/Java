import java.util.NoSuchElementException;

public class CircularQueue implements Queue{
    private int first;
    private int last;
    private int size;
    private String[] values;
    
    public CircularQueue(int initialCapacity){
        values = new String[initialCapacity];
    }
    
    public CircularQueue(){
        this(20);
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    

    public void enqueue(String value){
        if (isFull()){
            increaseCapacity();
        }
        last = (last + 1) % values.length;
        values[last] = value;
        size++;
    }
    
    private boolean isFull(){
        return (last + 1) % values.length == first;
    }
    
    private void increaseCapacity(){
        String[] temp = new String[values.length * 2 + 1];
        System.arraycopy(values, first + 1, temp, 1, values.length - (first + 1));
        System.arraycopy(values, 0, temp, 1 + values.length - (first + 1), first);
        first = 0;
        last = values.length - 1;
        values = temp;
    }
    

    public String dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        first = (first + 1) % values.length;
        String temp = values[first];
        size--;
        return temp;
    }

}