package datastructures;

import interfaces.ListInterface;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListInterface<E>
{
    class Node<E>
    {
        E value;
        Node<E> next;
        
        Node(E value){
            this.value = value;
            next = null;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int length;
    
    // No-args constructor
    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }
    
    // Constructor with args
    public LinkedList(E value){
        Node<E> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
        clear method removes all the elements from this list
    */
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }

    /**
        length method returns the number of elements in this list
    */
    public int length(){
        return length;
    }

    /**
        isEmpty method returns true if the list is empty
        @return True
    */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
        addLast method appends the specified element to the end of this list.
        @param e The element to be added to the end of the list
    */
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    
    /**
        addFirst method inserts the specified element at the beginning of this list.
        @param e The element to be added to the beginning of the list
    */
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
        removeFirst method removes and return the first element from the list.
        throws and exception if list is empty.
        @return The first element from the list
    */
    public E removeFirst(){
        E temp = pollFirst();
        if (temp == null){
            throw new NoSuchElementException("LinkedList is empty.");
        }
        return temp;
    }
    
    /**
        pollFirst method removes and return the first element from the list.
        returns null if list is empty.
        @return The first element from the list
    */
    public E pollFirst(){
        if (length == 0){
            return null;
        }
        Node<E> temp = head;
        if (length == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        temp.next = null;
        length--;
        return temp.value;
    }
    
    /**
        removeLast method removes and return the last element from the list
        @return The last element from the list
    */
    public E removeLast(){
        if (length == 0){
            throw new NoSuchElementException("LinkedList is empty.");
        }
        Node<E> temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            Node<E> pre = head;
            
            while (pre.next.next != null){
                pre = pre.next;
            }
            
            tail = pre;
            pre.next = null;
        }
        length--;
        
        return temp.value;        
    }
    
    /**
        The get method returns the element at the specified position in this list.
        Throws an exception if index is invalid.
        @param index The position of the list
        @return The element at the specified position
        @throws IndexOutOfBoundsException if index negative 0 or >= length
    */
    public E get(int index){
        Node<E> temp = getNode(index);
        if (temp == null){
            throw new IndexOutOfBoundsException("Invalid index."); 
        }
        return temp.value;
    }
    
    private Node<E> getNode(int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node<E> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        
        return temp;
    }
    
    /**
        getFirst method returns the first element of the list and throws an 
        exception if the list is empty.
    */
    public E getFirst(){
        Node<E> temp = getNode(0);
        if (temp == null){
            throw new NoSuchElementException("LinkedList is empty.");
        }
        return temp.value;
    }
    
    /**
        getLast method returns the last element of the list and throws an
        exception if the list is empty
    */
    public E getLast(){
        Node<E> temp = getNode(length-1);
        if (temp == null){
            throw new NoSuchElementException("LinkedList is empty.");
        }
        return temp.value;
    }
    
    /**
        set method replaces the element at the specified position in this list with the specified element.
        @param index The position of the list
        @param element The element to insert
    */
    public boolean set(int index, E element){
        Node<E> temp = getNode(index);
        if (temp != null){
            temp.value = element;
            return true;
        }
        return false;
    }
    
    
    /**
        add method inserts the specified element at the specified position in this list.
        @param index The position of the list
        @param element The element to insert
    */
    public void add(int index, E element){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        remove method removes the element at the specified position in this list.
        @param index The specified position in the list.
    */
    public E remove(int index){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        reverse method reverse the order of the list
    */
    public void reverse(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        peekFirst returns the first element in the list
    */
    public E peekFirst(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        peekLast method returns the last element in the list
    */
    public E peekLast(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        printList method
    */
    public void printList(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        indexOf method returns the first index of an 
        element in the list.
        @param e The element to get the index of.
        @return The index of an element
    */
    public int indexOf(E e){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        contains method returns true if this list contains the spefied element.
        @param o The object to remove
        @return True
    */
    public boolean contains(Object o){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
}