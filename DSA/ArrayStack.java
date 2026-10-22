package arraystack;

import java.util.NoSuchElementException;

public class ArrayStack<T>{
    private static final int DEFAULT_CAPACITY = 4;
    private int top;
    private int size;
    private T[] values;
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity){
        values = (T[]) new Object[initialCapacity];
        top = -1;
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public void display(){
        for (int i = top; i >= 0; i--){
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean isFull(){
        return top == size - 1;
    }
    
    public void push(T value){
        if (isFull()){
            increaseCapacity();
        }
        top++;
        size++;
        values[top] = value;
    }
    
    public T pop(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        T temp = values[top];
        top--;
        size--;
        return temp;
    }
    
    public T peek(int pos){
        if (top - pos + 1 < 0){
            throw new IndexOutOfBoundsException("Invalid position.");
        }
        T x = values[top - pos + 1];
        
        return x;
    }
    
    public T stackTop(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        return values[top];
    }
    
    @SuppressWarnings("unchecked")
    private void increaseCapacity(){
        T[] temp = (T[]) new Object[values.length * 2 + 1];
        System.arraycopy(values, 0, temp, 0, values.length);
        
        values = temp;
    }
    
    public static void main(String[] args){
        ArrayStack<Integer> s = new ArrayStack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        
        System.out.println(s.peek(7));
        s.display();
        
        
    }
}