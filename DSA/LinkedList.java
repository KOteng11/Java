package datastructures;

import interfaces.ListInterface;
import java.util.NoSuchElementException;
import java.util.Objects;

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
        return head == null;
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
        }
        temp.next = null;
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
    @Override
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
            throw new IndexOutOfBoundsException("Invalid Index.");
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
        Node<E> temp = getNode(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
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
        Node<E> pre = getNode(index - 1);
        Node<E> temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp.value;
    }
    
    /**
        reverse method reverse the order of the list
    */
    @Override
    public void reverse(){
        Node<E> temp = head;
        head = tail;
        tail = temp;
        Node<E> before = null;
        Node<E> after;
        
        while (temp != null){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    
    /**
        peekFirst returns the first element in the list
    */
    @Override
    public E peekFirst(){
        if (length == 0){
            return null;
        }
        return get(0);
    }
    
    /**
        peekLast method returns the last element in the list
    */
    @Override
    public E peekLast(){
        if(length == 0){
            return null;
        }
        return get(length - 1);
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
        int count = 0;
        
        while(temp != null){
            if (temp.value == e){
                return count;
            }
            ++count;
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
        boolean isFound = false;
        
        while(temp != null && !isFound){
            if(Objects.equals(temp.value, o))
            {
                isFound = true;
            }
            temp = temp.next;
        }
        return isFound;
    }
}