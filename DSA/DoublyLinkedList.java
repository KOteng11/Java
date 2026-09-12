package datastructures;

import interfaces.ListInterface;

public class DoublyLinkedList<E> implements ListInterface<E>
{
    class Node<E>
    {
        E value;
        Node<E> next;
        Node<E> prev;
        
        Node(E value){
            this.value = value;
            next = null;
            prev = null;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int length;
    
    // No-args constructor
    public DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }
    
    // Constructor with args
    public DoublyLinkedList(E value){
        Node<E> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
        clear method removes all the elements from this list
    */
    public void clear(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }

    /**
        length method returns the number of elements in this list
    */
    public int length(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }

    /**
        isEmpty method returns true if the list is empty
        @return True
    */
    public boolean isEmpty(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        addLast method appends the specified element to the end of this list.
        @param e The element to be added to the end of the list
    */
    public void addLast(E e){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        addFirst method inserts the specified element at the beginning of this list.
        @param e The element to be added to the beginning of the list
    */
    public void addFirst(E e){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }

    /**
        removeFirst method removes and return the first element from the list.
        throws and exception if list is empty.
        @return The first element from the list
    */
    public E removeFirst(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        pollFirst method removes and return the first element from the list.
        returns null if list is empty.
        @return The first element from the list
    */
    public E pollFirst(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        removeLast method removes and return the last element from the list
        @return The last element from the list
    */
    public E removeLast(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        The get method returns the element at the specified position in this list.
        Throws an exception if index is invalid.
        @param index The position of the list
    */
    public E get(int index){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        getFirst method returns the first element of the list and throws an 
        exception if the list is empty.
    */
    public E getFirst(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        getLast method returns the last element of the list and throws an
        exception if the list is empty
    */
    public E getLast(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        set method replaces the element at the specified position in this list with the specified element.
        @param index The position of the list
        @param element The element to insert
    */
    public boolean set(int index, E element){
        throw new UnsupportedOperationException("Method Not Implemented.");
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