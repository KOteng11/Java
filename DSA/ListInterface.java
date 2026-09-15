package interfaces;

public interface ListInterface<E> extends Collection<E>
{
    /**
        addLast method appends the specified element to the end of this list.
        @param e The element to be added to the end of the list
    */
    void addLast(E e);
    
    /**
        addFirst method inserts the specified element at the beginning of this list.
        @param e The element to be added to the beginning of the list
    */
    void addFirst(E e);

    /**
        removeFirst method removes and return the first element from the list.
        throws and exception if list is empty.
        @return The first element from the list
    */
    E removeFirst();
    
    /**
        pollFirst method removes and return the first element from the list.
        returns null if list is empty.
        @return The first element from the list
    */
    E pollFirst();
    
    /**
        removeLast method removes and return the last element from the list
        @return The last element from the list
    */
    E removeLast();
    
    /**
        The get method returns the element at the specified position in this list.
        Throws an exception if index is invalid.
        @param index The position of the list
    */
    E get(int index);
    
    /**
        getFirst method returns the first element of the list and throws an 
        exception if the list is empty.
    */
    E getFirst();
    
    /**
        getLast method returns the last element of the list and throws an
        exception if the list is empty
    */
    E getLast();
    
    /**
        set method replaces the element at the specified position in this list with the specified element.
        @param index The position of the list
        @param element The element to insert
    */
    boolean set(int index, E element);
    
    
    /**
        add method inserts the specified element at the specified position in this list.
        @param index The position of the list
        @param element The element to insert
    */
    void add(int index, E element);
    
    /**
        remove method removes the element at the specified position in this list.
        @param index The specified position in the list.
    */
    E remove(int index);
    
    /**
        reverse method reverse the order of the list
    */
    void reverse();
    
    /**
        peekFirst returns the first element in the list
    */
    E peekFirst();
    
    /**
        peekLast method returns the last element in the list
    */
    E peekLast();
    
    /**
        indexOf method returns the first index of an 
        element in the list.
        @param e The element to get the index of.
        @return The index of an element
    */
    int indexOf(E e);
    
}