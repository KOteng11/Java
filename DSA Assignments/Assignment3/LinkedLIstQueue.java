import java.util.NoSuchElementException;

public class LinkedListQueue implements Queue{
    private Node first;
    private Node last;
    private int length;
    
    class Node{
        String value;
        Node next;
        
        Node(String value){
            this.value = value;
            next = null;
        }
    }
    
    public LinkedListQueue(String value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }
    
    public LinkedListQueue(){
        first = null;
        last = null;
        length = 0;
    }
    
    public void enqueue(String value){
        Node newNode = new Node(value);
        if (length == 0){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    
    public String dequeue(){
        if (length == 0){
            throw new NoSuchElementException("Queue is empty.");
        }
        Node temp = first;
        if (length == 1){
            first = last = null;
        }else{
            first = first.next;
        }
        temp.next = null;
        length--;
        
        return temp.value;
    }
    
    public int size(){
        return length;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
}