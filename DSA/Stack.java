package datastructures;

public class Stack<E>{
    class Node<E>{
        E value;
        Node<E> next;
        
        Node(E value){
            this.value = value;
            next = null;
        }
    }
}