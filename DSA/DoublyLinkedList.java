package datastructures;

import interfaces.ListInterface;
import java.util.NoSuchElementException;
import java.util.Objects;

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
    @Override
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }

    /**
        length method returns the number of elements in this list
    */
    @Override
    public int length(){
        return length;
    }

    /**
        isEmpty method returns true if the list is empty
        @return True
    */
    @Override
    public boolean isEmpty(){
        return length == 0;
    }
    
    /**
        addLast method appends the specified element to the end of this list.
        @param e The element to be added to the end of the list
    */
    @Override
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    /**
        addFirst method inserts the specified element at the beginning of this list.
        @param e The element to be added to the beginning of the list
    */
    @Override
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    /**
        removeFirst method removes and return the first element from the list.
        throws and exception if list is empty.
        @return The first element from the list
    */
    @Override
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
    @Override
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
            head.prev = null;
            temp.next = null;
        }
        length--;
        
        return temp.value;
    }
    
    /**
        removeLast method removes and return the last element from the list
        @return The last element from the list
    */
    @Override
    public E removeLast(){
        if (length == 0){
            throw new NoSuchElementException("LinkedList is empty.");
        }
        Node<E> temp = tail;
        if (length == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        
        return temp.value;
    }
    
    /**
        The get method returns the element at the specified position in this list.
        Throws an exception if index is invalid.
        @param index The position of the list
    */
    @Override
    public E get(int index){
        Node<E> temp = getNode(index);
        if (temp == null){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return temp.value;
    }
    
    // getNode helper method
    private Node<E> getNode(int index){
        if (index < 0 || index >= length){
            return null;
        }
        
        Node<E> temp;
        if (index < length / 2){
            temp = head;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for (int i = length - 1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }
    
    /**
        getFirst method returns the first element of the list and throws an 
        exception if the list is empty.
    */
    @Override
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
    @Override
    public E getLast(){
        Node<E> temp = getNode(length - 1);
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
    @Override
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
    @Override
    public void add(int index, E element){
        if (index < 0 || index > length){
            throw new IndexOutOfBoundsException("Invalid index.");
        }   
        if (index == 0){
            addFirst(element);
            return;
        }
        if (index == length){
            addLast(element);
            return;
        }
        Node<E> newNode = new Node<>(element);
        Node<E> before = getNode(index - 1);
        Node<E> after = before.next;
        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;
    }
    
    /**
        remove method removes the element at the specified position in this list.
        @param index The specified position in the list.
    */
    @Override
    public E remove(int index){
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length - 1){
            return removeLast();
        }
        
        Node<E> before = getNode(index - 1);
        Node<E> temp = before.next;
        Node<E> after = temp.next;
        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
        length--;
        
        return temp.value;
    }
    
    /**
        reverse method reverse the order of the list
    */
    @Override
    public void reverse(){
        throw new UnsupportedOperationException("Method Not Implemented.");
    }
    
    /**
        peekFirst returns the first element in the list
    */
    @Override
    public E peekFirst(){
        Node<E> temp = getNode(0);
        if (temp != null){
            return temp.value;
        }
        return null;
    }
    
    /**
        peekLast method returns the last element in the list
    */
    @Override
    public E peekLast(){
        Node<E> temp = getNode(length - 1);
        if (temp != null){
            return temp.value;
        }
        return null;
    }
    
    /**
        indexOf method returns the first index of an 
        element in the list.
        @param e The element to get the index of.
        @return The index of an element
    */
    @Override
    public int indexOf(E e){
        Node<E> temp = head;
        for (int i = 0; i < length; i++){
            if (Objects.equals(temp.value, e)){
                return i;
            }
            temp = temp.next;
        }
        
        return -1;
    }
    
    /**
        contains method returns true if this list contains the spefied element.
        @param o The object to remove
        @return True
    */
    @Override
    public boolean contains(Object o){
        Node<E> temp = head;
        
        while (temp != null){
            if (Objects.equals(temp.value, o)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}