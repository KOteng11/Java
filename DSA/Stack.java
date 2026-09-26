package datastructures;

import java.util.NoSuchElementException;

public class Stack<E>{
    class Node<E>{
        E value;
        Node<E> next;
        
        Node(E value){
            this.value = value;
            next = null;
        }
    }
    
    private Node<E> top;
    private int height;
    
    // no-args constructor
    public Stack(){
        top = null;
        height = 0;
    }
    
    // Constructor
    public Stack(E value){
        Node<E> newNode = new Node<>(value);
        top = newNode;
        height = 1;
    }
    
    /**
        size method returns the height of the stack
        @return The height of the stack
    */
    public int size(){
        return height;
    }
    
    /**
        push method adds an element to the beginning of the list
        @param value The element to add at the beginning of the list
    */
    public void push(E value){
        Node<E> newNode = new Node<>(value);
        if (height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }
    
    /**
        peekFirst method returns the top element of the stack
        @return The top element of the stack
    */
    public E peekFirst(){
        if (height == 0){
            return null;
        }
        return top.value;
    }
    
    /**
        pollFirst method removes an element from the beginning of the list
        @return the element removed from the end of the list
    */
    public E pollFirst(){
        if (height == 0){
            return null;
        }
        Node<E> temp = top;
        if (height == 1){
            top = null;
        }else{
            top = temp.next;
            temp.next = null;
        }
        height--;
        
        return temp.value;
    }
    
    /**
        pop method removes an element from the beginning of the list
        @return The element to be removed
        @throws NoSuchElementException
    */
    public E pop(){
        E temp = pollFirst();
        if (temp == null){
            throw new NoSuchElementException("Stack is Empty.");
        }
        return temp;
    }
    
}